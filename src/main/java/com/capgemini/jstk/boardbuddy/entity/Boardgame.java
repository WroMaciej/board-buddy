package com.capgemini.jstk.boardbuddy.entity;

public class Boardgame {
	
	private Integer id;
	private String name;
	
	private Integer minPlayers;
	private Integer maxPlayers;
	
	private Boolean isHaveTeams;
	private Integer minTeams;
	private Integer maxTeams;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMinPlayers() {
		return minPlayers;
	}
	public void setMinPlayers(Integer minPlayers) {
		this.minPlayers = minPlayers;
	}
	public Integer getMaxPlayers() {
		return maxPlayers;
	}
	public void setMaxPlayers(Integer maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	public Boolean getIsHaveTeams() {
		return isHaveTeams;
	}
	public void setIsHaveTeams(Boolean isHaveTeams) {
		this.isHaveTeams = isHaveTeams;
	}
	public Integer getMinTeams() {
		return minTeams;
	}
	public void setMinTeams(Integer minTeams) {
		this.minTeams = minTeams;
	}
	public Integer getMaxTeams() {
		return maxTeams;
	}
	public void setMaxTeams(Integer maxTeams) {
		this.maxTeams = maxTeams;
	}
	
	

}
