package com.capgemini.jstk.boardbuddy.validation.exceptions.rest;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserErrorResponse {
	
	private final int resultStatus;
	private final String message;
	
	public UserErrorResponse(int resultStatus, String message) {
		super();
		this.resultStatus = resultStatus;
		this.message = message;
	}
	
	
	
	

}
