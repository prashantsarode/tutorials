package com.sampleprograms.spring.boot.rest.webservices.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.sampleprograms.spring.boot.rest.webservices.client")
public class RestfulWebServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServiceClientApplication.class, args);
	}

}

