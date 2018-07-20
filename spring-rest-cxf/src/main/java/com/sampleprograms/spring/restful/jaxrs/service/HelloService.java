package com.sampleprograms.spring.restful.jaxrs.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;



public class HelloService {

	@GET
	@Path("/world")
	public Response helloWorld() {
		return Response.ok("Hello World!!!").build();
	}
	
}
