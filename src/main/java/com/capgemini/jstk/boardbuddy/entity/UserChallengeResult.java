package com.capgemini.jstk.boardbuddy.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Number of team which user belongs to during a challenge
 */
public class UserChallengeResult {
	
	@Getter	@Setter
	private Integer id;
	@Getter	@Setter
	private Integer userId;
	@Getter	@Setter
	private Integer challengeResultId;
	@Getter	@Setter
	private Integer placeTaken;	

}
