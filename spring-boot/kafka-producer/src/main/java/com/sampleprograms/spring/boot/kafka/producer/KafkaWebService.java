package com.sampleprograms.spring.boot.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaWebService {

	@Autowired
	KafkaProducer kafkaProducer;
	
	@PostMapping(path = "/users")
	public void sendMessage(@RequestBody User user) {
		this.kafkaProducer.sendMessage(user);
	}
	
}
