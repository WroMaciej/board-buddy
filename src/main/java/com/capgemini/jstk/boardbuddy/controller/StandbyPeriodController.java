package com.capgemini.jstk.boardbuddy.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/standby/{userId}")
	public ResponseEntity<Collection<StandbyPeriodDto>> getUserStandbyPeriods(@PathVariable("userId") Integer userId){
		//TODO add global exception handler for user id searching
		Collection<StandbyPeriodDto> periods = userService.findAllCommonPeriods(userId);
		
	}
}
