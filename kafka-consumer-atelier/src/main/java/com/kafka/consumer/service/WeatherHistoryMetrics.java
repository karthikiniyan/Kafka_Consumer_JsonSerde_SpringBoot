package com.kafka.consumer.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("WeatherHistory")
public class WeatherHistoryMetrics implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
		
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	private HashMap<String, CityWeather> map = new HashMap<String, CityWeather>();
	
	private int count;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public HashMap<String, CityWeather> getMap() {
		return map;
	}
	public void setMap(HashMap<String, CityWeather> map) {
		this.map = map;
	}
	
	@Override
	public String toString() {
		
		for(Entry<String, CityWeather> cw : this.map.entrySet()){
			
			System.out.println("Key : " +cw.getKey() +", "+ "value :" + cw.getValue().toString());
			
		}
		return "WeatherHistoryMetrics"+ id;
	}

}
