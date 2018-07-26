package com.capgemini.jstk.boardbuddy.validation;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardbuddy.aop.LogActivity;
import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

@Component
public class UserValidator implements ValidatorFacade<UserDto>{

	@Override
	@LogActivity(message = "Validating user")
	public void validate(UserDto toValidate) throws IllegalOperationException {
			if (!toValidate.getEmail().contains("@")) {
				throw new IllegalOperationException("Wrong email adress.");
			}
			
	}

}
