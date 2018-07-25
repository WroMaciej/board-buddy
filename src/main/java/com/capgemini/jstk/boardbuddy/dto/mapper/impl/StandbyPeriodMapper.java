package com.capgemini.jstk.boardbuddy.dto.mapper.impl;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardbuddy.dto.StandbyPeriodDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.StandbyPeriod;

@Component
public class StandbyPeriodMapper implements Mapper<StandbyPeriod, StandbyPeriodDto> {

	@Override
	public StandbyPeriodDto toDto(StandbyPeriod entity) {
		final StandbyPeriodDto standbyPeriodDto = new StandbyPeriodDto(entity.getId());
		standbyPeriodDto.setUserId(entity.getUserId());
		standbyPeriodDto.setStartDate(entity.getStartDate());
		standbyPeriodDto.setEndDate(entity.getEndDate());
		return standbyPeriodDto;
	}

	@Override
	public StandbyPeriod toEntity(StandbyPeriodDto dto) {
		return null;
	}

}
