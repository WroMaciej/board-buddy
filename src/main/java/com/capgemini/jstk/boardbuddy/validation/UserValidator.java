package com.capgemini.jstk.boardbuddy.validation;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

@Component
public class UserValidator implements Validator<UserDto>{

	@Override
	public void isValid(UserDto toValidate) throws IllegalOperationException {
		if (!toValidate.getEmail().contains("@")) {
			throw new IllegalOperationException("Wrong email adress.");
		}
		if (toValidate.getScore() < 0 || toValidate.getScore() > 5000) {
			throw new IllegalArgumentException("Score out of bounds!");
		}

	}

	


}
