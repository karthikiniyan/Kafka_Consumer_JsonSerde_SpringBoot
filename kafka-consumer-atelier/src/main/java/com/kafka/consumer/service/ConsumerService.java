package com.kafka.consumer.service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.kafka.consumer.mongodb.repository.*;

@Service
public class ConsumerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerService.class);

	private final CountDownLatch latch = new CountDownLatch(1);

	@Autowired
	private WeatherRepository userRepository;

	@Autowired
	private WeatherHistoryRepository historyRespository;

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
		WeatherMetrics dat=new WeatherMetrics();
		dat.setCount(100);
		userRepository.save(dat);
	}

	@KafkaListener(topics = "Streams_output")

	public void receive(@Payload WeatherMetrics data,
			@Headers MessageHeaders headers) {
		LOGGER.info("receiveDataModel='{}'", data.toString());

		HashMap<String,CityWeather> map = data.getMap();

		String city = (String) map.keySet().toArray()[0];	

		List<WeatherMetrics> listfromDb = userRepository.findById(city);

		if(listfromDb != null && listfromDb.size() > 0) {
			WeatherMetrics fromDb = listfromDb.get(0);
			fromDb.setCount(data.getCount());
			fromDb.setMap(data.getMap());
			userRepository.save(fromDb);
		}
		else {
			userRepository.save(data);
		}

		WeatherHistoryMetrics wh = ConvertoWeatherHistory(data);

		persistIntoWeatherHistoryMetrics(wh);

	}

	public WeatherHistoryMetrics ConvertoWeatherHistory(WeatherMetrics data) {

		WeatherHistoryMetrics wh = new WeatherHistoryMetrics();
		wh.setId(data.getId());
		wh.setMap(data.getMap());
		wh.setCount(data.getCount());

		return wh;
	}

	public boolean persistIntoWeatherHistoryMetrics(WeatherHistoryMetrics wh) {

		historyRespository.save(wh);

		return true;

	}

}


