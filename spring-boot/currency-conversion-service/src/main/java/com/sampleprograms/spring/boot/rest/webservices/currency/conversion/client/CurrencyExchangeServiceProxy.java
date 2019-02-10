package com.sampleprograms.spring.boot.rest.webservices.currency.conversion.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sampleprograms.spring.boot.rest.webservices.currency.conversion.domain.CurrencyConversion;

@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion exchangeRate(@PathVariable("from") String from, @PathVariable("to") String to);

}
