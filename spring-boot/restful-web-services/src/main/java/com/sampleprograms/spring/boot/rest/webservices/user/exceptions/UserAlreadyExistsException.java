package com.sampleprograms.spring.boot.rest.webservices.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8920118726572060502L;

	public UserAlreadyExistsException(String message) {
		super(message);
	}

}
