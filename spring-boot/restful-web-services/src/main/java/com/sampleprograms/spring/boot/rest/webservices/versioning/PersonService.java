package com.sampleprograms.spring.boot.rest.webservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sampleprograms.spring.boot.rest.webservices.versioning.v1.Person;
import com.sampleprograms.spring.boot.rest.webservices.versioning.v2.Name;

import io.swagger.annotations.Api;

@RestController
@Api(description = "Demonstrates versioning schemes for REST API")
public class PersonService {

	
	@GetMapping("/v1/person")
	public Person getPersonV1() {
		return new Person("Sanvi");
	}
	
	@GetMapping("/v2/person") 
	public com.sampleprograms.spring.boot.rest.webservices.versioning.v2.Person getPersonV2() {
		return new com.sampleprograms.spring.boot.rest.webservices.versioning.v2.Person(new Name("Sanvi", "Sarode"));
	}
}