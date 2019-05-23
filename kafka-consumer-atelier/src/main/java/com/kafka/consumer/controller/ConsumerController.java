package com.kafka.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.consumer.service.ConsumerService;

@RestController("/kafka")
public class ConsumerController {

	@Autowired	
	private ConsumerService consumerservice;
	
	@GetMapping("/receive/{id}/{name}")
    public boolean receiveMessage(String name,String id) {
   // consumerservice.receiveMessage("receivetext");
		
		return true;
	}		
	
	

}
