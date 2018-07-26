package com.capgemini.jstk.boardbuddy.validation;

import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

public interface Validator<T> {
	
	public void validate(T toValidate) throws IllegalOperationException;

}
