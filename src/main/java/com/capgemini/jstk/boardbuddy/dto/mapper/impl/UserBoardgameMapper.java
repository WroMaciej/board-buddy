package com.capgemini.jstk.boardbuddy.dto.mapper.impl;

import com.capgemini.jstk.boardbuddy.dto.UserBoardgameDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.UserBoardgame;

public class UserBoardgameMapper implements Mapper<UserBoardgame, UserBoardgameDto>{

	@Override
	public UserBoardgameDto toDto(UserBoardgame entity) {
		final UserBoardgameDto userBoardgameDto = new UserBoardgameDto();
		userBoardgameDto.setId(entity.getId());
		userBoardgameDto.setBoardgameId(entity.getBoardgameId());
		userBoardgameDto.setUserId(entity.getUserId());
		return userBoardgameDto;
	}

	@Override
	public UserBoardgame toEntity(UserBoardgameDto dto) {
		return null;
	}

}
