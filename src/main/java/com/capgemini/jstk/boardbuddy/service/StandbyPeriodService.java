package com.capgemini.jstk.boardbuddy.service;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capgemini.jstk.boardbuddy.dto.StandbyPeriodDto;

@Service
public class StandbyPeriodService {
	
	
	public Optional<StandbyPeriodDto> commonPeriod(StandbyPeriodDto period1, StandbyPeriodDto period2){
		StandbyPeriodDto commonPeriod = null;
		Calendar startDate = commonPeriodStart(period1.getStartDate(), period2.getStartDate());
		Calendar endDate = commonPeriodEnd(period1.getEndDate(), period2.getEndDate());
		if (endDate.after(startDate)) {
			commonPeriod = new StandbyPeriodDto(null);
			commonPeriod.setStartDate(startDate);
			commonPeriod.setEndDate(endDate);
		}	
		return Optional.ofNullable(commonPeriod);
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
