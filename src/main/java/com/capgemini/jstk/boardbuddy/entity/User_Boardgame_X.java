package com.capgemini.jstk.boardbuddy.entity;

import lombok.Getter;
import lombok.Setter;

@Getter	@Setter
public class User_Boardgame_X {
	

	private Integer id; //TODO maybe delete?
	private Integer userId;
	private Integer boardgameId;
	
	
	public User_Boardgame_X(Integer id, Integer userId, Integer boardgameId) {
		this.id = id;
		this.userId = userId;
		this.boardgameId = boardgameId;
	}
	
	
	
}
