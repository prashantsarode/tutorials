package com.sampleprograms.spring.restful.jaxrs.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class OrdersService {
	
	@GET
	@Path("/hello/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public String helloWorld(@PathParam("name") String name) {
		return "Hello " + name;
	}
	
}
