package com.user.services.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException() {
		super("Id Not found ");
	}

	public ResourceNotFoundException(String massage) {
		super(massage);
	}

}
