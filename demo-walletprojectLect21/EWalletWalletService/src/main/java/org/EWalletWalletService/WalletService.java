package org.EWalletWalletService;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

	@Value("${user.onboarding.amount}")
	Double onBoardingAmount;

	@Autowired
	WalletRepository walletRepository;

	private static final String USER_CREATE_TOPIC = "user_create";

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

}
