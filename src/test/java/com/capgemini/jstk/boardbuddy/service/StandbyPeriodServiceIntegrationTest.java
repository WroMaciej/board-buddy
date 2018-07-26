package com.capgemini.jstk.boardbuddy.service;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jstk.boardbuddy.dao.StandbyPeriodDaoFacade;
import com.capgemini.jstk.boardbuddy.dto.StandbyPeriodDto;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StandbyPeriodServiceIntegrationTest {
	

	@Autowired
	private StandbyPeriodServiceFacade standbyPeriodService;
	
	@Autowired
	private StandbyPeriodDaoFacade standbyPeriodDaoFacade;

	
	@Test
	public void testAddStandbyPeriod() throws IllegalOperationException {
		// given
		StandbyPeriodDto toAdd = new StandbyPeriodDto(null);
		toAdd.setStartDate(new GregorianCalendar(2018, 7, 28, 12, 0));
		toAdd.setEndDate(new GregorianCalendar(2018, 7, 28, 16, 0));
		StandbyPeriodDto fullDto = new StandbyPeriodDto(11);
		fullDto.setStartDate(toAdd.getStartDate());
		fullDto.setEndDate(toAdd.getEndDate());
		fullDto.setActive(true);
		Optional<StandbyPeriodDto> returnedDto = Optional.of(fullDto);
		// when
		standbyPeriodService.addStandbyPeriod(1, toAdd);
		// then
		assertEquals(returnedDto, standbyPeriodDaoFacade.findById(11));
	}

}
