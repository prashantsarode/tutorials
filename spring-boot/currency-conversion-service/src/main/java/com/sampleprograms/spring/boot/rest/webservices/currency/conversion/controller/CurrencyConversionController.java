package com.sampleprograms.spring.boot.rest.webservices.currency.conversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sampleprograms.spring.boot.rest.webservices.currency.conversion.domain.CurrencyConversion;

@RestController
public class CurrencyConversionController {

	@GetMapping("/currency-convertor/from/{from}/to/{to}/amount/{amount}")
	public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal amount) {
		
		
		Map<String, String> uriVariables = new HashMap<> ();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
		
		CurrencyConversion currencyConversion = responseEntity.getBody();
		
		currencyConversion.setAmount(amount);
		currencyConversion.setConvertedAmount(currencyConversion.getAmount().multiply(currencyConversion.getConversionFactor()));
		
		return currencyConversion;
	}

}