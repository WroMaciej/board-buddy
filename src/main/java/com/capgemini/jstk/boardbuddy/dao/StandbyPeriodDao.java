package com.capgemini.jstk.boardbuddy.dao;

import java.util.Collection;
import java.util.Optional;

import com.capgemini.jstk.boardbuddy.dto.StandbyPeriodDto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;

public interface StandbyPeriodDao {
	
	public Optional<StandbyPeriodDto> findById(Integer id);
	
	public Collection<StandbyPeriodDto> findByUser(UserDto userDto);
	
	public Collection<StandbyPeriodDto> findAll();

	public void addStandbyPeriod(Integer userId, StandbyPeriodDto standbyPeriodDto);

	public void deleteStandbyPeriod(Integer userId, Integer deletingPeriodId);

}
