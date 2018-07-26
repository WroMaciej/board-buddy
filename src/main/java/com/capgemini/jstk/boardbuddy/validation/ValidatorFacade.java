package com.capgemini.jstk.boardbuddy.validation;

import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

public interface ValidatorFacade<T> {
	
	public void validate(T toValidate) throws IllegalOperationException;

}
