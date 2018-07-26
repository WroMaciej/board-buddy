package com.capgemini.jstk.boardbuddy.service;

import java.util.Optional;

import com.capgemini.jstk.boardbuddy.dto.StandbyPeriodDto;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

public interface StandbyPeriodServiceFacade {

	Optional<StandbyPeriodDto> commonPeriod(StandbyPeriodDto senderPeriod,
			StandbyPeriodDto receiverPeriod);

	void addStandbyPeriod(Integer userId, StandbyPeriodDto standbyPeriodDto)
			throws IllegalOperationException;

	void updateStandbyPeriod(Integer userId, StandbyPeriodDto updatedDto)
			throws IllegalOperationException, IllegalAccessException;
}
