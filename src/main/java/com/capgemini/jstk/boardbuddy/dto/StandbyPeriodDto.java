package com.capgemini.jstk.boardbuddy.dto;

import java.util.Calendar;

import lombok.Getter;
import lombok.Setter;

public class StandbyPeriodDto {
	
	@Getter
	private final Integer id;
	@Getter	@Setter
	private Integer userId;
	@Getter	@Setter
	private Calendar startDate;
	@Getter	@Setter
	private Calendar endDate;
	@Getter	@Setter
	private String comment;
	
	public StandbyPeriodDto(Integer id) {
		this.id = id;
	}
	
	

}
