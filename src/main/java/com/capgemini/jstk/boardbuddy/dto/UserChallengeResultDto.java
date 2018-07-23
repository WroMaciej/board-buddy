package com.capgemini.jstk.boardbuddy.dto;

import lombok.Getter;
import lombok.Setter;

public class UserChallengeResultDto {
	
	@Getter	@Setter
	private Integer id;
	@Getter	@Setter
	private Integer userId;
	@Getter	@Setter
	private Integer challengeResultId;
	@Getter	@Setter
	private Integer placeTaken;	

}
