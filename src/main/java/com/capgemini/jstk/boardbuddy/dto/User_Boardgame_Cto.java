package com.capgemini.jstk.boardbuddy.dto;

import lombok.Getter;
import lombok.Setter;

public class User_Boardgame_Cto {
	
	@Getter	
	private final Integer id;
	@Getter	@Setter
	private Integer userId;
	@Getter	@Setter
	private Integer boardgameId;
	
	public User_Boardgame_Cto(Integer id) {
		this.id = id;
	}
	
	

}
