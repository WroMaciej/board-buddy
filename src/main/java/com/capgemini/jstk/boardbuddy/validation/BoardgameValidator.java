package com.capgemini.jstk.boardbuddy.validation;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardbuddy.aop.LogActivity;
import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

@Component
public class BoardgameValidator implements ValidatorFacade<BoardgameDto> {

	@Override
	@LogActivity(message = "Validating boardgame")
	public void validate(BoardgameDto toValidate) throws IllegalOperationException {
		if (toValidate.getName().isEmpty()) {
			throw new IllegalOperationException("Boardgame must have a name.");
		}
	}

}
