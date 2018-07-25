package com.capgemini.jstk.boardbuddy.dto;

import lombok.Getter;
import lombok.Setter;

public class UserBoardgameCto {
	
	@Getter	
	private final Integer id;
	@Getter	@Setter
	private UserDto userDto;
	@Getter	@Setter
	private BoardgameDto boardgameDto;
	
	public UserBoardgameCto(Integer id) {
		super();
		this.id = id;
	}
	
	

}
