package com.sampleprograms.spring.boot.rest.webservices.currency.exchange.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import brave.sampler.Sampler;

@Component
public class CommonConfig {

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
}
