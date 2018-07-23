package com.capgemini.jstk.boardbuddy.entity;

/**
 * Winning position of given user and given challenge result
 */
public class UserChallengeResult {
	
	private Integer id;
	private Integer userId;
	private Integer challengeResultId;
	private Integer teamNumber;
	
	
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
	public Integer getTeamNumber() {
		return teamNumber;
	}
	public void setTeamNumber(Integer teamNumber) {
		this.teamNumber = teamNumber;
	}
	
	
	
	
	
	

}
