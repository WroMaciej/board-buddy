package com.capgemini.jstk.boardbuddy.controller;

import java.util.Calendar;
import java.util.Collection;
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
import com.fasterxml.jackson.annotation.JsonFormat;

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

	@GetMapping("/standby-periods/{userId1}/{userId2}/{startDate}/{endDate}")
	public ResponseEntity<Collection<StandbyPeriodDto>> getCommonStandbyPeriodFor2UsersAndGivenDatePeriod(
			@PathVariable("userId1") Integer userId1,
			@PathVariable("userId2") Integer userId2,
			@PathVariable("startDate") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
			Calendar startDate,
			@PathVariable("endDate") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
			Calendar endDate) {
		Stream<StandbyPeriodDto> twoUserCommons = userService.findCommonPeriodsWithAnotherUser(userId1, userId2).stream();
		Predicate<StandbyPeriodDto> startDateChecked = period -> period.getStartDate().after(startDate);
		Predicate<StandbyPeriodDto> endDateChecked = period -> period.getEndDate().before(endDate);
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
