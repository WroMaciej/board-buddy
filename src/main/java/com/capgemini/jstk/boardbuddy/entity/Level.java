package com.capgemini.jstk.boardbuddy.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Level of rank
 * @author MACIEWRO
 *
 */
public class Level {
	
	@Getter	@Setter
	private Integer id;
	@Getter	@Setter
	private Integer levelValue;
	@Getter	@Setter
	private String name;
	@Getter	@Setter
	private Integer minScore;
	
	public Level(Integer id, Integer levelValue, String name, Integer minScore) {
		this.id = id;
		this.levelValue = levelValue;
		this.name = name;
		this.minScore = minScore;
	}
	
	
	
	
}
