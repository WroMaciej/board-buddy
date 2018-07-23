package com.capgemini.jstk.boardbuddy.entity;

/**
 * Number of team which user belongs to during a challenge
 */
public class UserChallengeResult {
	
	private Integer id;
	private Integer userId;
	private Integer challengeResultId;
	private Integer placeTaken;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getChallengeResultId() {
		return challengeResultId;
	}
	public void setChallengeResultId(Integer challengeResultId) {
		this.challengeResultId = challengeResultId;
	}
	public Integer getPlaceTaken() {
		return placeTaken;
	}
	public void setPlaceTaken(Integer placeTaken) {
		this.placeTaken = placeTaken;
	}
	
	
	
	
	

}
