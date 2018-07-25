package com.capgemini.jstk.boardbuddy.dto.mapper.impl;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardbuddy.dto.User_Boardgame_Cto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.User_Boardgame_X;

@Component
public class User_BoardgameMapper implements Mapper<User_Boardgame_X, User_Boardgame_Cto>{

	@Override
	public User_Boardgame_Cto toDto(User_Boardgame_X entity) {
		final User_Boardgame_Cto user_Boardgame_Cto = new User_Boardgame_Cto(entity.getId());
		user_Boardgame_Cto.setBoardgameId(entity.getBoardgameId());
		user_Boardgame_Cto.setUserId(entity.getUserId());
		return user_Boardgame_Cto;
	}

	@Override
	public User_Boardgame_X toEntity(User_Boardgame_Cto dto) {
		return null;
	}

}
