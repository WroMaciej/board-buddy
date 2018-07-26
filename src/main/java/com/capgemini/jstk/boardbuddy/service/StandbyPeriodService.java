package com.capgemini.jstk.boardbuddy.service;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jstk.boardbuddy.dao.StandbyPeriodDao;
import com.capgemini.jstk.boardbuddy.dto.StandbyPeriodDto;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

@Service
public class StandbyPeriodService {
	
	private StandbyPeriodDao standbyPeriodDao;
	
	
	@Autowired
	public StandbyPeriodService(StandbyPeriodDao standbyPeriodDao) {
		super();
		this.standbyPeriodDao = standbyPeriodDao;
	}

	public Optional<StandbyPeriodDto> commonPeriod(StandbyPeriodDto senderPeriod, StandbyPeriodDto receiverPeriod){
		StandbyPeriodDto commonPeriod = null;
		Calendar startDate = commonPeriodStart(senderPeriod.getStartDate(), receiverPeriod.getStartDate());
		Calendar endDate = commonPeriodEnd(senderPeriod.getEndDate(), receiverPeriod.getEndDate());
		if (endDate.after(startDate)) {
			commonPeriod = new StandbyPeriodDto(null);
			commonPeriod.setStartDate(startDate);
			commonPeriod.setEndDate(endDate);
			commonPeriod.setUserId(receiverPeriod.getUserId());
		}
		return Optional.ofNullable(commonPeriod);
	}
	
	public void addStandbyPeriod(Integer userId, StandbyPeriodDto standbyPeriodDto) throws IllegalOperationException {
		standbyPeriodDao.addStandbyPeriod(userId, standbyPeriodDto);
	}
	
	public void deleteStandbyPeriod(Integer userId, Integer deletingPeriodId) throws IllegalAccessException {
		standbyPeriodDao.deleteStandbyPeriod(userId, deletingPeriodId);
	}
	
	public void updateStandbyPeriod(Integer userId, StandbyPeriodDto updatedDto) throws IllegalOperationException, IllegalAccessException {
		standbyPeriodDao.updateStandbyPeriod(userId, updatedDto);
	}
	
	private Calendar commonPeriodStart(Calendar startOfPeriod1, Calendar startOfPeriod2) {
		return getLaterDate(startOfPeriod1, startOfPeriod2);
		
	}
	
	private Calendar commonPeriodEnd(Calendar endOfPeriod1, Calendar endOfPeriod2) {
		return getEarlierDate(endOfPeriod1, endOfPeriod2);
	}
	
	private Calendar getEarlierDate(Calendar date1, Calendar date2) {
		if (date1.before(date2)) {
			return date1;
		}
		return date2;
	}
	
	private Calendar getLaterDate(Calendar date1, Calendar date2) {
		if (date1.before(date2)) {
			return date2;
		}
		return date1;
	}
	
	

}
