package com.capgemini.jstk.boardbuddy.dto;

import java.util.Calendar;

import lombok.Getter;
import lombok.Setter;

public class ChallengeResultDto {
	
	@Getter	@Setter
	private Integer id;
	@Getter @Setter
	private Integer boardgameId;
	@Getter	@Setter
	private Calendar dateOfStart;
	@Getter	@Setter
	private Calendar dateOfEnd;

}
