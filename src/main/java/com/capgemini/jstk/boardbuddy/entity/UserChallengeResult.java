package com.capgemini.jstk.boardbuddy.entity;

import lombok.Getter;
import lombok.Setter;


public class UserChallengeResult {
	
	@Getter	@Setter
	private Integer id;
	@Getter	@Setter
	private Integer userId;
	@Getter	@Setter
	private Integer challengeResultId;
	@Getter	@Setter
	private Integer placeTaken;
	
	
	public UserChallengeResult(Integer id, Integer userId, Integer challengeResultId, Integer placeTaken) {
		super();
		this.id = id;
		this.userId = userId;
		this.challengeResultId = challengeResultId;
		this.placeTaken = placeTaken;
	}
	
	

}
