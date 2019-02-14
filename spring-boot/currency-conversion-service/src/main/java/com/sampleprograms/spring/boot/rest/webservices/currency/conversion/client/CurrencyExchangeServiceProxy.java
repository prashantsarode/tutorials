package com.sampleprograms.spring.boot.rest.webservices.currency.conversion.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sampleprograms.spring.boot.rest.webservices.currency.conversion.domain.CurrencyConversion;

@FeignClient(name = "netflix-zuul-gateway-server")
//@FeignClient(name = "currency-exchange", url = "localhost:8000")
//@FeignClient(name = "currency-exchange-service")
//@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion exchangeRate(@PathVariable("from") String from, @PathVariable("to") String to);

}
