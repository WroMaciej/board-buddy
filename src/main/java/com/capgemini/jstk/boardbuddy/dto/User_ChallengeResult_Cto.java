package com.capgemini.jstk.boardbuddy.dto;

import lombok.Getter;
import lombok.Setter;

public class User_ChallengeResult_Cto {
	
	@Getter
	private final Integer id;
	@Getter	@Setter
	private Integer userId;
	@Getter	@Setter
	private Integer challengeResultId;
	@Getter	@Setter
	private Integer placeTaken;
	
	public User_ChallengeResult_Cto(Integer id) {
		super();
		this.id = id;
	}	
	
	

}
