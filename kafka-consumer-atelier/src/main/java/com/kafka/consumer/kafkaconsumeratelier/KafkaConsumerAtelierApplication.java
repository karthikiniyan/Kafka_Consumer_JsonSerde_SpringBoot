package com.kafka.consumer.kafkaconsumeratelier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.kafka.consumer")
public class KafkaConsumerAtelierApplication {

	public static void main(String[] args) {

		SpringApplication.run(KafkaConsumerAtelierApplication.class, args);
				
	}

}
