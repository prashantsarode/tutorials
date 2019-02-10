package com.sampleprograms.spring.boot.rest.webservices.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestfulWebServicesUsingFeign {

	@Autowired
	private RestfulWebServiceUsersProxy proxy;

	@GetMapping("/test/{userId}")
	public Resource<User> test(@PathVariable Integer userId) {
		System.out.println("User Id : " + userId);
		return proxy.retrieveUser(userId);
	}

	@GetMapping("/test")
	public List<User> test() {
		return proxy.getAllUsers();
	}

	@PostMapping("/test")
	public ResponseEntity<Object> test(@RequestBody User user) {
		return proxy.createUser(user);
	}

}
