package com.capgemini.jstk.boardbuddy.entity;

import lombok.Getter;
import lombok.Setter;


public class UserBoardgame {
	
	@Getter	@Setter
	private Integer id;
	@Getter	@Setter
	private Integer userId;
	@Getter	@Setter
	private Integer boardgameId;
	
	
	public UserBoardgame(Integer id, Integer userId, Integer boardgameId) {
		this.id = id;
		this.userId = userId;
		this.boardgameId = boardgameId;
	}
	
	
	
}
