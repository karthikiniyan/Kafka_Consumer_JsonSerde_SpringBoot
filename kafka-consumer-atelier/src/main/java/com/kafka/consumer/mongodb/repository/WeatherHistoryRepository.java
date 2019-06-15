package com.kafka.consumer.mongodb.repository;

import com.kafka.consumer.service.*;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeatherHistoryRepository extends MongoRepository<WeatherHistoryMetrics, Integer> {

	

}
