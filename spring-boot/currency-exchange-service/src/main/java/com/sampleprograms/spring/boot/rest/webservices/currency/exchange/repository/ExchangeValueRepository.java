package com.sampleprograms.spring.boot.rest.webservices.currency.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sampleprograms.spring.boot.rest.webservices.currency.exchange.domain.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo(String from, String to);
	
}
