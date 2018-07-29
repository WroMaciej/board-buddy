package com.capgemini.jstk.boardbuddy.controller;

import java.util.Collection;

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

@RestController
public class StandbyPeriodController {

	@Autowired
	StandbyPeriodServiceFacade standbyPeriodService;
	@Autowired
	UserServiceFacade userService;
	
	//TODO add global exception handler for user id searching
	
	@GetMapping("/standby-periods/common/{userId}")
	public ResponseEntity<Collection<StandbyPeriodDto>> getAllCommonStandbyPeriods(@PathVariable("userId") Integer userId){
		Collection<StandbyPeriodDto> periods = userService.findAllCommonPeriods(userId);
		return ResponseEntity.ok().body(periods);
	}
	
	@GetMapping("/standby-periods/{userId}")
	public ResponseEntity<Collection<StandbyPeriodDto>> getAllUserStandbyPeriods(@PathVariable("userId") Integer userId){
		Collection<StandbyPeriodDto> periods = userService.findAllCommonPeriods(userId);
		return ResponseEntity.ok().body(periods);
	}
	
	@PostMapping("/standby-periods/")
	public ResponseEntity<StandbyPeriodDto> createStandbyPeriod(@RequestBody StandbyPeriodDto standbyPeriodDto){
		standbyPeriodService.addStandbyPeriod(userId, standbyPeriodDto);
		return ResponseEntity.ok().body(standbyPeriodDto);
		//return ResponseEntity.ok().body("Standby period created succesfully");
		
	}
	
}
