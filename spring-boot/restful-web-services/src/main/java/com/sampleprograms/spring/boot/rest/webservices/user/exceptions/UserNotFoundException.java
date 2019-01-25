package com.sampleprograms.spring.boot.rest.webservices.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6851458406630489847L;

	public UserNotFoundException(String message) {
		super(message);
	}
	
}
