package com.capgemini.jstk.boardbuddy.validation;

public interface Validator<T> {
	
	public boolean isValid(T toValidate);

}
