package com.capgemini.jstk.boardbuddy.validation.exceptions;

public interface Validator<T> {
	
	public boolean isValid(T toValidate);

}
