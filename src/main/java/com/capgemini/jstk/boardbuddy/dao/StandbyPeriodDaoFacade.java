package com.capgemini.jstk.boardbuddy.dao;

import java.util.Collection;
import java.util.Optional;

import com.capgemini.jstk.boardbuddy.dto.StandbyPeriodDto;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

public interface StandbyPeriodDaoFacade {

	public Optional<StandbyPeriodDto> findById(Integer id);

	public Collection<StandbyPeriodDto> findByUser(Integer userId);

	public Collection<StandbyPeriodDto> findAll();

	public StandbyPeriodDto addStandbyPeriod(Integer userId, StandbyPeriodDto standbyPeriodDto)
			throws IllegalOperationException;

	public void updateStandbyPeriod(Integer userId, StandbyPeriodDto updatedDto)
			throws IllegalOperationException, IllegalAccessException;

	void deleteStandbyPeriod(Integer userId, Integer deletingPeriodId)
			throws IllegalAccessException;

}
