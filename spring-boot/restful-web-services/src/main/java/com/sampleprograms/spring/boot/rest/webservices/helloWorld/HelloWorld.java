package com.sampleprograms.spring.boot.rest.webservices.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	// GET
	// URI - /hello-world
	// Method "Hello World"
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String helloWorld() {
		return "Hello World!!!";
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
