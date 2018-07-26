package com.capgemini.jstk.boardbuddy.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.capgemini.jstk.boardbuddy.dao.impl.StandbyPeriodDaoImpl;
import com.capgemini.jstk.boardbuddy.dto.StandbyPeriodDto;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class StandbyPeriodServiceTest {

	@Mock
	private StandbyPeriodDaoImpl standbyPeriodDaoMock;

	
	private StandbyPeriodService standbyPeriodService;

	@Before
	public void setup() {
		standbyPeriodService = new StandbyPeriodService(standbyPeriodDaoMock);
	}

	@Test
	public void testHasCommonPeriod() {
		// given
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
		// when
		Optional<StandbyPeriodDto> commonPeriod = standbyPeriodService.commonPeriod(period1, period2);
		// then
		assertTrue(commonPeriod.isPresent());
		assertEquals(new GregorianCalendar(2018, 1, 1, 10, 0), commonPeriod.get().getStartDate());
		assertEquals(new GregorianCalendar(2018, 1, 1, 14, 0), commonPeriod.get().getEndDate());
	}

	@Test
	public void testDontHaveCommonPeriod() {
		// given
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
		// when
		Optional<StandbyPeriodDto> commonPeriod = standbyPeriodService.commonPeriod(period1, period2);
		// then
		assertFalse(commonPeriod.isPresent());
	}

	@Test
	public void testAddStandbyPeriod() throws IllegalOperationException {
		// given
		StandbyPeriodDto toAdd = new StandbyPeriodDto(null);
		toAdd.setStartDate(new GregorianCalendar(2018, 7, 28, 12, 0));
		toAdd.setEndDate(new GregorianCalendar(2018, 7, 28, 16, 0));
		StandbyPeriodDto fullDto = new StandbyPeriodDto(1);
		fullDto.setStartDate(toAdd.getStartDate());
		fullDto.setEndDate(toAdd.getEndDate());
		fullDto.setActive(true);
		Optional<StandbyPeriodDto> returnedDto = Optional.of(fullDto);
		// when
		Mockito.when(standbyPeriodDaoMock.findById(Matchers.any(Integer.class))).thenReturn(returnedDto);
		standbyPeriodService.addStandbyPeriod(1, toAdd);
		//TODO how to check if it really was added?
		// then
		assertEquals(returnedDto, standbyPeriodDaoMock.findById(1));
	}

}
