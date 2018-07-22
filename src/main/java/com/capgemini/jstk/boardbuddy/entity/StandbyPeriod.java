package com.capgemini.jstk.boardbuddy.entity;

import java.util.Calendar;

/**
 * Availibility period for game
 * @author MACIEWRO
 *
 */
public class StandbyPeriod {

	private Integer id;
	private Integer userId;
	
	private Calendar startDate;
	private Calendar endDate;
	
	private String comment;
	
}
