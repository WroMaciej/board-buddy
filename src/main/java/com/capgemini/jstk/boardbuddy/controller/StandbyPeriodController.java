package com.capgemini.jstk.boardbuddy.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.jstk.boardbuddy.dto.StandbyPeriodDto;
import com.capgemini.jstk.boardbuddy.service.StandbyPeriodServiceFacade;
import com.capgemini.jstk.boardbuddy.service.UserServiceFacade;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;
import com.capgemini.jstk.boardbuddy.validation.exceptions.rest.IllegalDateException;

@RestController
public class StandbyPeriodController {

	@Autowired
	StandbyPeriodServiceFacade standbyPeriodService;
	@Autowired
	UserServiceFacade userService;

	// TODO add global exception handler for user id searching

	@GetMapping("/standby-periods/")
	public ResponseEntity<Collection<StandbyPeriodDto>> getAllStandbyPeriods() {
		Collection<StandbyPeriodDto> periods = standbyPeriodService.getAllStandbyPeriods();
		return ResponseEntity.ok().body(periods);
	}

	@GetMapping("/standby-periods/common/{userId}")
	public ResponseEntity<Collection<StandbyPeriodDto>> getAllCommonStandbyPeriods(
			@PathVariable("userId") Integer userId) {
		Collection<StandbyPeriodDto> periods = userService.findAllCommonPeriods(userId);
		return ResponseEntity.ok().body(periods);
	}

	@GetMapping("/standby-periods/{userId}")
	public ResponseEntity<Collection<StandbyPeriodDto>> getAllUserStandbyPeriods(
			@PathVariable("userId") Integer userId) {
		Collection<StandbyPeriodDto> periods = standbyPeriodService.findUserStandbyPeriods(userId);
		return ResponseEntity.ok().body(periods);
	}
	
	private enum DayPart{
		START, END;
	}
	
	/**
	 * Converting string with given day to calendar with start of day
	 * @param dayToConvert with "dd.MM.yyyy" format
	 * @return Full calendar date
	 * @throws ParseException 
	 */
	private Calendar dayToCalendar(DayPart dayPart, String dayToConvert) throws ParseException {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(dayToConvert);	
		if (dayPart == DayPart.START) {
			stringBuilder.append(" 00:00:01");
		}
		else if (dayPart == DayPart.END) {
			stringBuilder.append(" 23:59:59");
		}
		LocalDate date = LocalDate.parse(stringBuilder.toString(), dateFormat);
		Calendar calendar = GregorianCalendar.from(date.atStartOfDay(ZoneId.of("GMT")));
		return calendar;
	}
	
	@GetMapping("/date/{day}")
	public ResponseEntity<Calendar> getTime(@PathVariable("day") String day) throws ParseException{
		return ResponseEntity.ok().body(dayToCalendar(DayPart.START, day));
	}
	
	@GetMapping("/standby-periods/{userId1}/{userId2}")
	public ResponseEntity<Collection<StandbyPeriodDto>> getCommonStandbyPeriodFor2Users(
			@PathVariable("userId1") Integer userId1,
			@PathVariable("userId2") Integer userId2){
		Collection<StandbyPeriodDto> twoUserCommons = userService.findCommonPeriodsWithAnotherUser(userId1, userId2);
		return ResponseEntity.ok().body(twoUserCommons);
	}	

	@GetMapping("/standby-periods/{userId1}/{userId2}/{startDay}/{endDay}")
	public ResponseEntity<Collection<StandbyPeriodDto>> getCommonStandbyPeriodFor2UsersAndGivenDaysPeriod(
			@PathVariable("userId1") Integer userId1,
			@PathVariable("userId2") Integer userId2,
			@PathVariable("startDay") String startDateDay,
			@PathVariable("endDay") String endDateDay) throws IllegalDateException {
		
		Predicate<StandbyPeriodDto> startDateChecked = null;
		Predicate<StandbyPeriodDto> endDateChecked = null;
		try {
			Calendar startDate = dayToCalendar(DayPart.START, startDateDay);
			startDateChecked = period -> period.getStartDate().after(startDate);
		} catch (ParseException e) {
			throw new IllegalDateException("Wrong date: " + startDateDay + "  . Use format 'dd.MM.yyyy'");
		}
		try {
			Calendar endDate = dayToCalendar(DayPart.END, endDateDay);
			endDateChecked = period -> period.getEndDate().before(endDate);
		} catch (ParseException e) {
			throw new IllegalDateException("Wrong date: " + endDateDay + "  . Use format 'dd.MM.yyyy'");
		}
		
		Stream<StandbyPeriodDto> twoUserCommons = userService.findCommonPeriodsWithAnotherUser(userId1, userId2).stream();
		
		
		Collection<StandbyPeriodDto> filteredList = twoUserCommons.filter(startDateChecked.and(endDateChecked)).collect(Collectors.toList());
		return ResponseEntity.ok().body(filteredList);
	}

	@PostMapping("/standby-periods/{userId}")
	public ResponseEntity<StandbyPeriodDto> createStandbyPeriod(
			@PathVariable("userId") Integer userId, @RequestBody StandbyPeriodDto standbyPeriodDto)
			throws IllegalOperationException {
		StandbyPeriodDto createdDto = standbyPeriodService.addStandbyPeriod(userId,
				standbyPeriodDto);
		return ResponseEntity.ok().body(createdDto);
	}

}
