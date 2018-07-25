package com.capgemini.jstk.boardbuddy.entity;

import lombok.Getter;
import lombok.Setter;


@Getter	@Setter
public class Level {
	

	private Integer id;
	private Integer levelValue;
	private String name;
	private Integer minScore;
	
	public Level(Integer id, Integer levelValue, String name, Integer minScore) {
		this.id = id;
		this.levelValue = levelValue;
		this.name = name;
		this.minScore = minScore;
	}
	
	
	
	
}
