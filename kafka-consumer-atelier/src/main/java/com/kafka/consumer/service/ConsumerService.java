package com.kafka.consumer.service;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.kafka.consumer.mongodb.repository.WeatherRepository;

@Service
public class ConsumerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerService.class);

	private final CountDownLatch latch = new CountDownLatch(1);
	
	@Autowired
	private WeatherRepository userRepository;
	public CountDownLatch getLatch(){
		
		return latch;
				
	}

	/*
	 * @KafkaListener(topics="outputtopic") public void receiveMessage(final String
	 * message) {
	 * 
	 * LOGGER.info("received message='{}'", message); latch.countDown();
	 * 
	 * }
	 */
	public void insert() {
		 Weather dat=new Weather();
		 dat.setCity("sgsdg");
		 userRepository.save(dat);
	}
	 //@KafkaListener(topics = "meenatopic")
	    public void receive(@Payload Weather data,
	                        @Headers MessageHeaders headers) {
		 LOGGER.info("received DataModel='{}'", data);

	        headers.keySet().forEach(key -> {
	        	LOGGER.info("{}: {}", key, headers.get(key));
	        });
	    }

}
	
	
