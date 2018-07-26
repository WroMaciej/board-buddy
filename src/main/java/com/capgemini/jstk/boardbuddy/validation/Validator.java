package com.capgemini.jstk.boardbuddy.validation;

import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

public interface Validator<T> {
	
	public void isValid(T toValidate) throws IllegalOperationException;

}
