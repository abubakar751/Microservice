package com.userservice.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException() {
		super("Resource Not Found on server !!");
	}
public ResourceNotFoundException(String massage) {
	super(massage);
}
}
