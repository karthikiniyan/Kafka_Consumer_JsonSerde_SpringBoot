package com.kafka.consumer.kafkaconsumeratelier;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import com.kafka.consumer.service.Weather;

import org.apache.kafka.common.serialization.StringDeserializer;


@Configuration
@EnableKafka

public class ConsumerConfig {
	

	@Value("${kafka.bootstrap.servers}")
	private String bootstrapServers;
	
	@Bean
	public Map<String,Object> ConsConfig(){
		final Map<String,Object> props = new HashMap();
		
		props.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
	    props.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	    props.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
	    props.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG, "jsonexample");
	    props.put(org.apache.kafka.clients.consumer.ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
	    props.put(JsonDeserializer.TRUSTED_PACKAGES, "com.kafka.producer.service.DataModel");
		return props;
    	
    }
	
	 @Bean
	  public ConsumerFactory<String, Weather> consumerFactory() {
	    return new DefaultKafkaConsumerFactory<String, Weather>(ConsConfig(),new StringDeserializer(),
                new JsonDeserializer<>(Weather.class,false));
	  }
	
	 @Bean
	  public ConcurrentKafkaListenerContainerFactory<String, Weather> kafkaListenerContainerFactory() {

	    final ConcurrentKafkaListenerContainerFactory<String, Weather> factory
	        = new ConcurrentKafkaListenerContainerFactory<String, Weather>();

	    factory.setConsumerFactory(consumerFactory());

	    return factory;
	  }
	
	
	 @Bean
	  public ConsumerConfig receive() {
	    return new ConsumerConfig();
	  }
	
	
}
