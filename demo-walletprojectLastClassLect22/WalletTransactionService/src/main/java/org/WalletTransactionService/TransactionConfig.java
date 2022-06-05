package org.WalletTransactionService;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TransactionConfig {
	
	
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
	
	
	Properties getProducerConfig() {

		Properties properties = new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		return properties;

	}

	ProducerFactory<String, String> getProducerFactory() {
		return new DefaultKafkaProducerFactory(getProducerConfig());

	}

	@Bean
	KafkaTemplate<String, String> getKafkaTemplate() {
		return new KafkaTemplate<>(getProducerFactory());
	}
	
	
	
	
	@Bean
	RestTemplate getTemplate(){
		
		return new RestTemplate();
		
	}
	
	
	

}
