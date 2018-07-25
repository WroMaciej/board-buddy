package com.capgemini.jstk.boardbuddy.entity;

import java.util.Calendar;

import lombok.Getter;
import lombok.Setter;

@Getter	@Setter
public class ChallengeResult {


	private Integer id;
	private Integer boardgameId;
	private Calendar dateOfStart;
	private Calendar dateOfEnd;
	
	public ChallengeResult(Integer id, Integer boardgameId, Calendar dateOfStart, Calendar dateOfEnd) {
		super();
		this.id = id;
		this.boardgameId = boardgameId;
		this.dateOfStart = dateOfStart;
		this.dateOfEnd = dateOfEnd;
	}
	
	

	
}
