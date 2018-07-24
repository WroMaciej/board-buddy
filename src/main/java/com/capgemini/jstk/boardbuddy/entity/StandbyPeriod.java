package com.capgemini.jstk.boardbuddy.entity;

import java.util.Calendar;

import lombok.Getter;
import lombok.Setter;

/**
 * Availability period for game
 * @author MACIEWRO
 *
 */
public class StandbyPeriod {

	@Getter	@Setter
	private Integer id;
	@Getter	@Setter
	private Integer userId;
	@Getter	@Setter
	private Calendar startDate;
	@Getter	@Setter
	private Calendar endDate;
	@Getter	@Setter
	private String comment;
	@Getter @Setter
	private boolean isActive;

	
	
	
	
}
