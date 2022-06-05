package org.NotificationService;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class NotificationConfig {

	Properties getConsumerConfig() {

		Properties properties = new Properties();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);

		return properties;

	}

	ConsumerFactory<String, String> getConsumerFactory() {
		return new DefaultKafkaConsumerFactory(getConsumerConfig());

	}

	@Bean
	SimpleMailMessage getMailMsg() {
		return new SimpleMailMessage();
	}

	@Bean
	JavaMailSender getMailSender() {

		JavaMailSenderImpl jms = new JavaMailSenderImpl();

		jms.setHost("smtp.gmail.com");
		jms.setPort(587);
		jms.setUsername("jdbl2951@gmail.com");
		jms.setPassword("northnewyork@123./");

		Properties properties = jms.getJavaMailProperties();
		//props.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.starttls.enable ", "true");
		properties.put("mail.debug", "true");

		return jms;

	}

}
