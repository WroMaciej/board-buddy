package com.capgemini.jstk.boardbuddy.entity;

/**
 * Level of rank
 * @author MACIEWRO
 *
 */
public class Level {
	
	private Integer id;
	private Integer levelValue;
	private String name;
	private Integer minScore;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLevelValue() {
		return levelValue;
	}
	public void setLevelValue(Integer levelValue) {
		this.levelValue = levelValue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMinScore() {
		return minScore;
	}
	public void setMinScore(Integer minScore) {
		this.minScore = minScore;
	}

	
	
}
