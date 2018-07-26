package com.capgemini.jstk.boardbuddy.validation;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardbuddy.aop.LogActivity;
import com.capgemini.jstk.boardbuddy.dto.StandbyPeriodDto;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

@Component
public class StandbyPeriodValidator implements ValidatorFacade<StandbyPeriodDto> {

	@Override
	@LogActivity(message = "Validating standby period")
	public void validate(StandbyPeriodDto toValidate) throws IllegalOperationException {
		if (toValidate.getStartDate() == null || toValidate.getEndDate() == null) {
			throw new IllegalOperationException("No such data in standby period record. Standby period has to contain both start and end date.");
		}
		
		if (toValidate.getStartDate().after(toValidate.getEndDate())) {
			throw new IllegalOperationException("Wrong data. Start date has to be before end date.");

		}
	}

}
