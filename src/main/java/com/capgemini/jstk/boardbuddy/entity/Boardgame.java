package com.capgemini.jstk.boardbuddy.entity;

import lombok.Getter;
import lombok.Setter;

public class Boardgame {
	
	@Getter	@Setter
	private Integer id;
	@Getter	@Setter
	private String name;
	
	public Boardgame(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

}
