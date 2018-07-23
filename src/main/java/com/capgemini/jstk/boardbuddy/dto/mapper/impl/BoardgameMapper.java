package com.capgemini.jstk.boardbuddy.dto.mapper.impl;

import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.Boardgame;

public class BoardgameMapper implements Mapper<Boardgame, BoardgameDto>{

	@Override
	public BoardgameDto toDto(Boardgame entity) {
		final BoardgameDto boardgameDto = new BoardgameDto();
		boardgameDto.setId(entity.getId());
		boardgameDto.setName(entity.getName());
		return boardgameDto;
	}

	@Override
	public Boardgame toEntity(BoardgameDto dto) {
		return null;
	}

}
