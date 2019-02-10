package com.sampleprograms.spring.boot.rest.webservices.client;

import java.awt.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import feign.Client;
import feign.Contract;
import feign.RequestInterceptor;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;

@Configuration
public class RestfulWebServiceClientConfig {

//	//@Bean
//	public RestfulWebServiceUsersProxy proxy() {
//
//		return Feign.builder()
//				.client(new OkHttpClient())
//				.contract(new SpringMvcContract())
//				.encoder(new JacksonEncoder()).decoder(new JacksonDecoder())
//				.requestInterceptor(new BasicAuthRequestInterceptor("admin", "admin"))
//				.logLevel(Logger.Level.FULL)
//				.target(RestfulWebServiceUsersProxy.class, "http://localhost:9000");
//
//	}

//	@Bean
//	public Client httpClient() {
//		return new OkHttpClient();
//	}

	@Bean
	public Contract contract() {
		return new SpringMvcContract();
	}

//	@Bean
//	public Encoder encoder() {
//		return new JacksonEncoder();
//	}
//	
//	@Bean
//	public Decoder decoder() {
//		return new JacksonDecoder();
//	}

	@Bean
	public Decoder feignDecoder() {
		return new JacksonDecoder(customObjectMapper());
	}

	public ObjectMapper customObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		// Customize as much as you want
		// objectMapper.readerFor(MappingJacksonValue.class);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.reader().forType(MappingJacksonValue.class);
		return objectMapper;
	}

	@Bean
	public RequestInterceptor requestInterceptor() {
		return new BasicAuthRequestInterceptor("admin", "admin");
	}

}
