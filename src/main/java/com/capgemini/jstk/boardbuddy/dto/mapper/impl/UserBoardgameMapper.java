package com.capgemini.jstk.boardbuddy.dto.mapper.impl;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardbuddy.dto.UserBoardgameCto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.UserBoardgame;

@Component
public class UserBoardgameMapper implements Mapper<UserBoardgame, UserBoardgameCto>{

	@Override
	public UserBoardgameCto toDto(UserBoardgame entity) {
		final UserBoardgameCto userBoardgameCto = new UserBoardgameCto(entity.getId());
		userBoardgameCto.setBoardgameDto(entity.getBoardgameId());
		userBoardgameCto.setUserDto(entity.getUserId());
		return userBoardgameCto;
	}

	@Override
	public UserBoardgame toEntity(UserBoardgameCto dto) {
		return null;
	}

}
