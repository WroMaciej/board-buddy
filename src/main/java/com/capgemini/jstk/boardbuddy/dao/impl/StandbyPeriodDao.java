package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardbuddy.dao.StandbyPeriodDaoFacade;
import com.capgemini.jstk.boardbuddy.dao.impl.mock.CommonDatabaseMock;
import com.capgemini.jstk.boardbuddy.dto.StandbyPeriodDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.StandbyPeriod;
import com.capgemini.jstk.boardbuddy.validation.ValidatorFacade;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;
import com.capgemini.jstk.boardbuddy.validation.exceptions.NoSuchElementInDatabaseException;

@Repository
public class StandbyPeriodDao implements StandbyPeriodDaoFacade {

	private ValidatorFacade<StandbyPeriodDto> standbyPeriodValidatorFacade;
	private Mapper<StandbyPeriod, StandbyPeriodDto> standbyPeriodMapper;
	private Collection<StandbyPeriod> standbyPeriods;

	@Autowired
	public StandbyPeriodDao(ValidatorFacade<StandbyPeriodDto> standbyPeriodValidator,
			Mapper<StandbyPeriod, StandbyPeriodDto> standbPeriodMapper, CommonDatabaseMock commonDatabaseMock) {
		super();
		this.standbyPeriodValidatorFacade = standbyPeriodValidator;
		this.standbyPeriodMapper = standbPeriodMapper;
		standbyPeriods = commonDatabaseMock.getStandbyPeriods();
	}

	@Override
	public Optional<StandbyPeriodDto> findById(Integer id) {
		return Optional.ofNullable(standbyPeriodMapper.toDto(
				standbyPeriods.stream().filter(standbyPeriod -> standbyPeriod.getId().equals(id)).findFirst().get()));
	}

	@Override
	public Collection<StandbyPeriodDto> findAll() {
		Collection<StandbyPeriodDto> standbyPeriodDtos = new ArrayList<>();
		standbyPeriods.forEach(standbyPeriod -> standbyPeriodDtos.add(standbyPeriodMapper.toDto(standbyPeriod)));
		return standbyPeriodDtos;
	}

	@Override
	public Collection<StandbyPeriodDto> findByUser(Integer userId) {
		Collection<StandbyPeriodDto> userStandbyPeriods = new ArrayList<>();
		Stream<StandbyPeriod> userPeriods = standbyPeriods.stream()
				.filter(standbyPeriodDto -> standbyPeriodDto.getUserId().equals(userId));
		userPeriods.forEach(standbyPeriod -> userStandbyPeriods.add(standbyPeriodMapper.toDto(standbyPeriod)));
		return userStandbyPeriods;
	}

	@Override
	public StandbyPeriodDto addStandbyPeriod(Integer userId, StandbyPeriodDto standbyPeriodDto) throws IllegalOperationException {
		StandbyPeriod toAdd = new StandbyPeriod(getUniqueId(), userId, standbyPeriodDto.getStartDate(),
				standbyPeriodDto.getEndDate(), standbyPeriodDto.getComment(), true);
		standbyPeriodValidatorFacade.validate(standbyPeriodMapper.toDto(toAdd));
		standbyPeriods.add(toAdd);
		return standbyPeriodMapper.toDto(toAdd);
	}

	private int getUniqueId() {
		int maxId = 0;
		for (StandbyPeriod period : standbyPeriods) {
			if (period.getId() > maxId) {
				maxId = period.getId();
			}
		}
		return Integer.valueOf(maxId + 1);
	}



	@Override
	public void deleteStandbyPeriod(Integer userId, Integer deletingPeriodId)
			throws IllegalAccessException {
		StandbyPeriod toDelete = getStandbyPeriodFromDatabase(deletingPeriodId);
		if (!toDelete.getUserId().equals(userId)) {
			throw new IllegalAccessException("Access denied. Attempt of deleting period from another user.");
		}
		standbyPeriods.remove(toDelete);
	}

	private StandbyPeriod getStandbyPeriodFromDatabase(Integer standbyPeriodId) {
		Optional<StandbyPeriod> standbyPeriod = standbyPeriods.stream()
				.filter(period -> period.getId().equals(standbyPeriodId)).findFirst();
		if (!standbyPeriod.isPresent()) {
			throw new NoSuchElementInDatabaseException(
					"Standby period to be deleted does not exist! Standby period ID: " + standbyPeriodId);
		}
		return standbyPeriod.get();
	}

	@Override
	public void updateStandbyPeriod(Integer userId, StandbyPeriodDto updatedDto)
			throws IllegalOperationException, IllegalAccessException {
		StandbyPeriod toUpdate = getStandbyPeriodFromDatabase(updatedDto.getId());
		if (!toUpdate.getUserId().equals(userId)) {
			throw new IllegalAccessException("Access denied. Attempt of deleting period from another user.");
		}
		standbyPeriodValidatorFacade.validate(standbyPeriodMapper.toDto(toUpdate));
		toUpdate.setStartDate(updatedDto.getStartDate());
		toUpdate.setEndDate(updatedDto.getEndDate());
		toUpdate.setComment(updatedDto.getComment());
	}

}
