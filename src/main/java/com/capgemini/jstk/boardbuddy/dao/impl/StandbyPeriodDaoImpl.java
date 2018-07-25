package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardbuddy.dao.StandbyPeriodDao;
import com.capgemini.jstk.boardbuddy.dao.impl.mock.CommonDatabaseMock;
import com.capgemini.jstk.boardbuddy.dto.StandbyPeriodDto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.StandbyPeriod;

@Repository
public class StandbyPeriodDaoImpl implements StandbyPeriodDao {
	
	private Mapper<StandbyPeriod, StandbyPeriodDto> standbyPeriodMapper;
	private Collection<StandbyPeriod> standbyPeriods;
	
	@Autowired
	public StandbyPeriodDaoImpl(Mapper<StandbyPeriod, StandbyPeriodDto> standbPeriodMapper,
			CommonDatabaseMock commonDatabaseMock) {
		super();
		this.standbyPeriodMapper = standbPeriodMapper;
		standbyPeriods = commonDatabaseMock.getStandbyPeriods();
	}

	@Override
	public Optional<StandbyPeriodDto> findById(Integer id) {
		return Optional.ofNullable(
				standbyPeriodMapper.toDto(
						standbyPeriods.stream().filter(standbyPeriod -> standbyPeriod.getId().equals(id)).findFirst().get() ) );
	}

	@Override
	public Collection<StandbyPeriodDto> findAll() {
		Collection<StandbyPeriodDto> standbyPeriodDtos = new ArrayList<>();
		standbyPeriods.forEach(standbyPeriod -> standbyPeriodDtos.add(standbyPeriodMapper.toDto(standbyPeriod)));
		return standbyPeriodDtos;
	}

	@Override
	public Collection<StandbyPeriodDto> findByUser(UserDto userDto) {
		Collection<StandbyPeriodDto> userStandbyPeriods = new ArrayList<>();
		Stream<StandbyPeriod> userPeriods = standbyPeriods.stream().filter(standbyPeriodDto -> standbyPeriodDto.getUserId().equals(userDto.getId()));
		userPeriods.forEach(standbyPeriod -> userStandbyPeriods.add(standbyPeriodMapper.toDto(standbyPeriod)));
		return userStandbyPeriods;
	}

	@Override
	public void addStandbyPeriod(Integer userId, StandbyPeriodDto standbyPeriodDto) {
		StandbyPeriod toAdd = new StandbyPeriod(getUniqueId(), userId, standbyPeriodDto.getStartDate(), standbyPeriodDto.getEndDate(), standbyPeriodDto.getComment(), true);
		standbyPeriods.add(toAdd);
	}
	
	private Integer getUniqueId() {
		Integer maxId = Integer.valueOf(0);
		for (StandbyPeriod period : standbyPeriods) {
			if (period.getId() > maxId) {
				maxId = period.getId();
			}
		}
		return Integer.valueOf(maxId + 1);
		
	}
	
}
