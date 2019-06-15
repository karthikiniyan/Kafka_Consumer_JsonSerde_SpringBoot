package com.kafka.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.consumer.mongodb.repository.WeatherRepository;
import com.kafka.consumer.service.ConsumerService;
import com.kafka.consumer.service.WeatherMetrics;

@RestController
@RequestMapping("/")
public class ConsumerController {

	@Autowired	
	private ConsumerService consumerservice;
	
	@Autowired
	private WeatherRepository userRepository;
	
	@GetMapping("/getAll")
    public boolean receiveMessage() {
   // consumerservice.receiveMessage("receivetext");
	List<WeatherMetrics> list =	userRepository.findById("vellor");
	WeatherMetrics ff = list.get(0);
		
		return true;
	}		
	
	

}
