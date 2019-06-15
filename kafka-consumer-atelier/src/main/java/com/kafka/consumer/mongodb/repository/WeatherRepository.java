package com.kafka.consumer.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.kafka.consumer.service.WeatherMetrics;

public interface WeatherRepository extends MongoRepository<WeatherMetrics, Integer> {
	
	public List<WeatherMetrics> findByMapCity(String City);
	
	public List<WeatherMetrics> findById(String City);

}
