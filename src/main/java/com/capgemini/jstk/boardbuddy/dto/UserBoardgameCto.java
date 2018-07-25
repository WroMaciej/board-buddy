package com.capgemini.jstk.boardbuddy.dto;

import lombok.Getter;
import lombok.Setter;

public class UserBoardgameCto {
	
	@Getter	
	private final Integer id;
	@Getter	@Setter
	private Integer userId;
	@Getter	@Setter
	private Integer boardgameId;
	
	public UserBoardgameCto(Integer id) {
		this.id = id;
	}
	
	

}
