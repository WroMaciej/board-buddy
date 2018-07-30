package com.capgemini.jstk.boardbuddy.validation.exceptions.rest.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.jstk.boardbuddy.validation.exceptions.rest.UserErrorResponse;
import com.capgemini.jstk.boardbuddy.validation.exceptions.rest.UserNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<UserErrorResponse> userNotFoundExceptionHandler(UserNotFoundException exception){
		UserErrorResponse response = new UserErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
		return new ResponseEntity<UserErrorResponse>(response, HttpStatus.NOT_FOUND);
	}

}
