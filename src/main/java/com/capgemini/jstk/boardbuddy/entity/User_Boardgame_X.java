package com.capgemini.jstk.boardbuddy.entity;

import lombok.Getter;
import lombok.Setter;


public class User_Boardgame_X {
	
	@Getter	@Setter
	private Integer id;
	@Getter	@Setter
	private Integer userId;
	@Getter	@Setter
	private Integer boardgameId;
	
	
	public User_Boardgame_X(Integer id, Integer userId, Integer boardgameId) {
		this.id = id;
		this.userId = userId;
		this.boardgameId = boardgameId;
	}
	
	
	
}
