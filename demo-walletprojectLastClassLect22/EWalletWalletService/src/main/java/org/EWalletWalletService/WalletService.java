package org.EWalletWalletService;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

	@Value("${user.onboarding.amount}")
	Double onBoardingAmount;

	@Autowired
	WalletRepository walletRepository;

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	private static final String USER_CREATE_TOPIC = "user_create";
	private static final String TXN_CREATE_TOPIC = "txn_create";
	private static final String WALLET_UPDATE_TOPIC = "wallet_update";

	@KafkaListener(topics = { USER_CREATE_TOPIC }, groupId = "jdbl20_grp")
	public void walletCreate(String message) throws Exception {

		JSONObject jsonObject = (JSONObject) new JSONParser().parse(message);

		if (!jsonObject.containsKey("userId")) {
			throw new Exception("userId is not present in the user event");
		}

		int userId = ((Long) jsonObject.get("userId")).intValue();

		Wallet wallet = Wallet.builder().balance(onBoardingAmount).userId(userId).build();

		walletRepository.save(wallet);
	}

	@KafkaListener(topics = { TXN_CREATE_TOPIC }, groupId = "jdbl20_grp")
	public void walletUpdate(String message) throws Exception {

		JSONObject jsonObject = (JSONObject) new JSONParser().parse(message);

		Integer receiverId = ((Long) jsonObject.get("receiver")).intValue();
		Integer senderId = ((Long) jsonObject.get("sender")).intValue();
		Double amount = (Double) jsonObject.get("amount");
		String txnId = (String) jsonObject.get("txnId");

		JSONObject walletUpdateEvent = new JSONObject();

		walletUpdateEvent.put("txnId", txnId);

		Wallet senderWallet = walletRepository.findByUserId(senderId);

		if (senderWallet.getBalance() < amount) {

			walletUpdateEvent.put("status", "FAILED");
		} else {

			walletRepository.updateWallet(receiverId, amount);

			walletRepository.updateWallet(senderId, 0 - amount);

			walletUpdateEvent.put("status", "SUCCESSFUL");

		}

		kafkaTemplate.send(WALLET_UPDATE_TOPIC, walletUpdateEvent.toJSONString());

	}

}
