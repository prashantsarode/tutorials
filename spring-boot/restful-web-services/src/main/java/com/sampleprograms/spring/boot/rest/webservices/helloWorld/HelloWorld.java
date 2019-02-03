package com.sampleprograms.spring.boot.rest.webservices.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class HelloWorld {

	@Autowired
	private MessageSource messageSource;

	// GET
	// URI - /hello-world
	// Method "Hello World"
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	@ApiOperation(notes = "This API is internationalized. The default response is in US-EN howwver using Accept-Language request header, response for other language can be get.", value = "")
	public String helloWorld() {
		return messageSource.getMessage("hello.world.message", null, LocaleContextHolder.getLocale());
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World!!!");
	}

	@GetMapping(path = "/hello-world-bean/path-variable/{message}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String message) {
		return new HelloWorldBean(message);
	}

}
