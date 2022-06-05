package org.NotificationService;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

	@Autowired
	SimpleMailMessage simpleMailMessage;
	
	
	
	@Autowired
	JavaMailSender jms;
	
	
	
	private static final String TXN_COMPLETE_TOPIC = "txn_complete";
	

	@KafkaListener(topics = { TXN_COMPLETE_TOPIC }, groupId = "jdbl20_grp")
	public void sendNotif(String message) throws Exception {

		JSONObject jsonObject = (JSONObject) new JSONParser().parse(message);

		String txnId = (String) jsonObject.get("txnId");

		String status = (String) jsonObject.get("status");
		String senderEmail = (String) jsonObject.get("sender");
		String receiverEmail = (String) jsonObject.get("receiver");
		
		Double amount = (Double) jsonObject.get("amount");
		
		
		
		simpleMailMessage.setText("Hi , your txn with id " + txnId + "got " + status);
		
		simpleMailMessage.setTo(senderEmail);
		simpleMailMessage.setSubject("Payment Notification");
		simpleMailMessage.setFrom("jdbl2951@gmail.com");
		
		
	//	jms.send(simpleMailMessage);
		
		if("SUCCESSFUL".equals(status)){
			simpleMailMessage.setText("Hi, you received amount " + amount + "from user" + senderEmail +"in your wallet" );
			
			simpleMailMessage.setTo(receiverEmail);
			jms.send(simpleMailMessage);

			
		}
		
		
	
	

}
}
