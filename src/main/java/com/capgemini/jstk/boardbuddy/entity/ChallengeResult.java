package com.capgemini.jstk.boardbuddy.entity;

import java.util.Calendar;

import lombok.Getter;
import lombok.Setter;

public class ChallengeResult {

	@Getter	@Setter
	private Integer id;
	@Getter	@Setter
	private Calendar dateOfStart;
	@Getter	@Setter
	private Calendar dateOfEnd;
	
	
	public ChallengeResult(Integer id, Calendar dateOfStart, Calendar dateOfEnd) {
		super();
		this.id = id;
		this.dateOfStart = dateOfStart;
		this.dateOfEnd = dateOfEnd;
	}
	
}
