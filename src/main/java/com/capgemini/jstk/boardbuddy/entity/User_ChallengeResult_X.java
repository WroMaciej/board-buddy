package com.capgemini.jstk.boardbuddy.entity;

import lombok.Getter;
import lombok.Setter;

@Getter	@Setter
public class User_ChallengeResult_X {
	

	private Integer id;
	private Integer userId;
	private Integer challengeResultId;
	private Integer placeTaken;
	
	
	public User_ChallengeResult_X(Integer id, Integer userId, Integer challengeResultId, Integer placeTaken) {
		super();
		this.id = id;
		this.userId = userId;
		this.challengeResultId = challengeResultId;
		this.placeTaken = placeTaken;
	}
	
	

}
