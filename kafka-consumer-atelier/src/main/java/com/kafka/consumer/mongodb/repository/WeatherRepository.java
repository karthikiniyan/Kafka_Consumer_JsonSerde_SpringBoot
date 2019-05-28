package com.kafka.consumer.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.kafka.consumer.service.WeatherMetrics;

public interface WeatherRepository extends MongoRepository<WeatherMetrics, Integer> {
	
	

}
