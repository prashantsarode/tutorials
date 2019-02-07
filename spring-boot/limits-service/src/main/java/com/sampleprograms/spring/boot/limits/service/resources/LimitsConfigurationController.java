package com.sampleprograms.spring.boot.limits.service.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sampleprograms.spring.boot.limits.service.beans.LimitConfiguration;
import com.sampleprograms.spring.boot.limits.service.config.Configuration;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration config;

	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		return new LimitConfiguration(config.getMinimum(), config.getMaximum());
	}
	
}
