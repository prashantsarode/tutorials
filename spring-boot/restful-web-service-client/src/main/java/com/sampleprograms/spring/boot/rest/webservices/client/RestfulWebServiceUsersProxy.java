package com.sampleprograms.spring.boot.rest.webservices.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "restful-web-services", url = "localhost:9000", configuration = RestfulWebServiceClientConfig.class)
public interface RestfulWebServiceUsersProxy {
	
	//@RequestLine("GET")
	@GetMapping("/users")
	public List<User> getAllUsers();
	
	@RequestMapping(method = RequestMethod.GET, value = "/users/{userId}")
	public Resource<User> retrieveUser(@PathVariable("userId") Integer userId);
	
	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public ResponseEntity<Object> createUser(User user); 

}
