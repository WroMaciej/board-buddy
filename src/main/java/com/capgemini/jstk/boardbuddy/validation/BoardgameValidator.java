package com.capgemini.jstk.boardbuddy.validation;

import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

public class BoardgameValidator implements Validator<BoardgameDto> {

	@Override
	public void validate(BoardgameDto toValidate) throws IllegalOperationException {
		if (toValidate.getName().isEmpty()) {
			throw new IllegalOperationException("Boardgame must have a name.");
		}
	}

}
