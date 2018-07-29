package com.capgemini.jstk.boardbuddy.validation.exceptions.rest;

import com.capgemini.jstk.boardbuddy.validation.exceptions.NoSuchElementInDatabaseException;

public class UserNotFoundException extends NoSuchElementInDatabaseException{

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
	}
	
	

}
