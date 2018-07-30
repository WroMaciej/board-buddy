package com.capgemini.jstk.boardbuddy.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.capgemini.jstk.boardbuddy.dto.StandbyPeriodDto;
import com.capgemini.jstk.boardbuddy.service.impl.StandbyPeriodService;
import com.capgemini.jstk.boardbuddy.service.impl.UserService;

@RunWith(MockitoJUnitRunner.class)
public class StandbyPeriodControllerTest {

	@Mock
	StandbyPeriodService standbyPeriodServiceMock;
	@Mock
	UserService userServiceMock;

	StandbyPeriodController standbyPeriodController;
	Collection<StandbyPeriodDto> standbyPeriods;

	@Before
	public void setup() {
		standbyPeriodController = new StandbyPeriodController(standbyPeriodServiceMock,
				userServiceMock);
		standbyPeriods = new ArrayList<>();
		standbyPeriods.add(new StandbyPeriodDto(7, 1, new GregorianCalendar(2018, 7, 25, 8, 0),
				new GregorianCalendar(2018, 7, 25, 10, 0), null, true));
	}

	@Test
	public void testGetUserPeriods() {
		// given
		Mockito.when(standbyPeriodServiceMock.findUserStandbyPeriods(Integer.valueOf(1)))
				.thenReturn(standbyPeriods);
		// when
		ResponseEntity<Collection<StandbyPeriodDto>> userId1response = standbyPeriodController
				.getUserStandbyPeriods(Integer.valueOf(1));
		// then
		assertEquals(HttpStatus.OK, userId1response.getStatusCode());
	}

}
