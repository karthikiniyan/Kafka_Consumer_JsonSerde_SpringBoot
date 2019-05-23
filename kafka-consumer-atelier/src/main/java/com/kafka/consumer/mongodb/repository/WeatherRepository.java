package com.kafka.consumer.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.kafka.consumer.service.Weather;

public interface WeatherRepository extends MongoRepository<Weather, Integer> {
	
	

}
