package com.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobleExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class	)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
		String message = ex.getMessage();
 ApiResponse apiResponse = ApiResponse.builder().massage(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
	}

}
