package com.kafka.consumer.kafkaconsumeratelier;

import com.kafka.consumer.mongodb.repository.WeatherRepository;
import com.kafka.consumer.service.Weather;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = WeatherRepository.class)
@Configuration
public class MongoDBConfig {


	/*
	 * @Bean CommandLineRunner commandLineRunner(WeatherRepository userRepository) {
	 * return strings -> { userRepository.save(new Weather());
	 * 
	 * 
	 * }; }
	 */
}
