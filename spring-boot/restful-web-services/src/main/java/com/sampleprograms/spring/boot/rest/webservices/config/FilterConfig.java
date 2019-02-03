package com.sampleprograms.spring.boot.rest.webservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Configuration
public class FilterConfig {

	@Bean
	public FilterProvider userPropertiesFilter() {
		SimpleBeanPropertyFilter ssnFilter = SimpleBeanPropertyFilter.serializeAllExcept("socialSecurityNumber", "phoneNumber");
		return new SimpleFilterProvider().addFilter("UserFilter", ssnFilter);
	}
		
}
