package org.WalletTransactionService;

import java.util.UUID;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	RestTemplate restTemplate;

	private static final String TXN_CREATE_TOPIC = "txn_create";
	private static final String WALLET_UPDATE_TOPIC = "wallet_update";
	private static final String TXN_COMPLETE_TOPIC = "txn_complete";

	public String createTnx(Transaction transaction) {

		transaction.setTxnId(UUID.randomUUID().toString());

		transaction.setTransactionStatus(TransactionStatus.PENDING);
		transactionRepository.save(transaction);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("sender", transaction.getSenderUserId());
		jsonObject.put("receiver", transaction.getReceiverUserId());
		jsonObject.put("amount", transaction.getAmount());
		jsonObject.put("txnId", transaction.getTxnId());

		kafkaTemplate.send(TXN_CREATE_TOPIC, jsonObject.toJSONString());

		return transaction.getTxnId();
	}

	// will get back here

	@KafkaListener(topics = { WALLET_UPDATE_TOPIC }, groupId = "jdbl20_grp")
	public void updateTxn(String message) throws Exception {

		JSONObject jsonObject = (JSONObject) new JSONParser().parse(message);

		String txnId = (String) jsonObject.get("txnId");

		String status = (String) jsonObject.get("status");

		TransactionStatus transactionStatus;

		if ("FAILED".equals(status)) {

			transactionStatus = TransactionStatus.FAILED;
		} else {

			transactionStatus = TransactionStatus.SUCCESSFUL;
		}

		Transaction transaction = transactionRepository.findByTxnId(txnId);
		transaction.setTransactionStatus(transactionStatus);

		transactionRepository.save(transaction);

		Integer receiverId = transaction.getReceiverUserId();
		Integer senderId = transaction.getSenderUserId();

		JSONObject sender = restTemplate.getForObject("http://localhost:9001/user?id=" + senderId, JSONObject.class);
		String senderEmail = (String) sender.get("email");

		JSONObject receiver = restTemplate.getForObject("http://localhost:9001/user?id=" + receiverId,
				JSONObject.class);

		String receiverEmail = (String) receiver.get("email");

		JSONObject txnCompleteEvent = new JSONObject();
		txnCompleteEvent.put("tnxId", txnId);
		txnCompleteEvent.put("sender", senderEmail);
		txnCompleteEvent.put("receiver", receiverEmail);
		txnCompleteEvent.put("status", transaction.getTransactionStatus().name());
		txnCompleteEvent.put("amount", transaction.getAmount());

		kafkaTemplate.send(TXN_COMPLETE_TOPIC, txnCompleteEvent.toJSONString());

	}

}
