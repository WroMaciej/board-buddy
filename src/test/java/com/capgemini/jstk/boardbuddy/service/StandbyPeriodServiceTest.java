package com.capgemini.jstk.boardbuddy.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;

import org.junit.Test;

import com.capgemini.jstk.boardbuddy.dto.StandbyPeriodDto;

public class StandbyPeriodServiceTest {
	
	@Test
	public void testHasCommonPeriod() {
		//given
		Calendar start1 = new GregorianCalendar(2018, 1, 1, 1, 0);
		Calendar end1 = new GregorianCalendar(2018, 1, 1, 14, 0);
		Calendar start2 = new GregorianCalendar(2018, 1, 1, 10, 0);
		Calendar end2 = new GregorianCalendar(2018, 1, 1, 22, 0);
		StandbyPeriodDto period1 = new StandbyPeriodDto(null);
		period1.setStartDate(start1);
		period1.setEndDate(end1);
		StandbyPeriodDto period2 = new StandbyPeriodDto(null);
		period2.setStartDate(start2);
		period2.setEndDate(end2);
		StandbyPeriodService standbyPeriodService = new StandbyPeriodService();
		//when
		Optional<StandbyPeriodDto> commonPeriod = standbyPeriodService.commonPeriod(period1, period2);
		//then
		assertTrue(commonPeriod.isPresent());
		assertEquals(new GregorianCalendar(2018,1,1,10,0), commonPeriod.get().getStartDate());
		assertEquals(new GregorianCalendar(2018,1,1,14,0), commonPeriod.get().getEndDate());
	}
	
	@Test
	public void testDontHaveCommonPeriod() {
		//given
				Calendar start1 = new GregorianCalendar(2018, 1, 1, 1, 0);
				Calendar end1 = new GregorianCalendar(2018, 1, 1, 10, 0);
				Calendar start2 = new GregorianCalendar(2018, 1, 1, 14, 0);
				Calendar end2 = new GregorianCalendar(2018, 1, 1, 22, 0);
				StandbyPeriodDto period1 = new StandbyPeriodDto(null);
				period1.setStartDate(start1);
				period1.setEndDate(end1);
				StandbyPeriodDto period2 = new StandbyPeriodDto(null);
				period2.setStartDate(start2);
				period2.setEndDate(end2);
				StandbyPeriodService standbyPeriodService = new StandbyPeriodService();
				//when
				Optional<StandbyPeriodDto> commonPeriod = standbyPeriodService.commonPeriod(period1, period2);
				//then
				assertFalse(commonPeriod.isPresent());
	}

}
