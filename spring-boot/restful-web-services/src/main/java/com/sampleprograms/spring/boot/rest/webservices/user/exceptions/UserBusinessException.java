package com.sampleprograms.spring.boot.rest.webservices.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserBusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -599935438345734531L;

	public UserBusinessException(String message) {
		super(message);
	}
	
}
