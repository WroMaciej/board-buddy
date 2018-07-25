package com.capgemini.jstk.boardbuddy.entity;

import lombok.Getter;

import lombok.Setter;
@Getter	@Setter
public class Boardgame {
	

	private Integer id;
	private String name;
	
	public Boardgame(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	

}
