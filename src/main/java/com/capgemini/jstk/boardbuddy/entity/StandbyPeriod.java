package com.capgemini.jstk.boardbuddy.entity;

import java.util.Calendar;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class StandbyPeriod {

	private Integer id;
	private Integer userId;
	private Calendar startDate;
	private Calendar endDate;
	private String comment;
	private boolean isActive;
	
	public StandbyPeriod(Integer id, Integer userId, Calendar startDate, Calendar endDate, String comment,
			boolean isActive) {
		this.id = id;
		this.userId = userId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.comment = comment;
		this.isActive = isActive;
	}
	
	

	
	
	
	
}
