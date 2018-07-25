package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardbuddy.dao.BoardgameDao;
import com.capgemini.jstk.boardbuddy.dao.impl.mock.CommonDatabaseMock;
import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.Boardgame;

@Repository
public class BoardgameDaoImpl implements BoardgameDao {

	private static Collection<Boardgame> boardgames;
	private Mapper<Boardgame, BoardgameDto> boardgameMapper;
	
	
	public BoardgameDaoImpl(CommonDatabaseMock commonDatabaseMock, Mapper<Boardgame, BoardgameDto> boardgameMapper) {
		this.boardgameMapper = boardgameMapper;
		boardgames = commonDatabaseMock.getBoardgames();
	}

	@Override
	public Optional<BoardgameDto> findById(Integer id) {
		return Optional.ofNullable(
				boardgameMapper.toDto(boardgames.stream().filter(boardgame -> boardgame.getId().equals(id)).findFirst().get()));
	}

	@Override
	public Optional<BoardgameDto> findByName(String name) {
		return Optional.ofNullable(
				boardgameMapper.toDto(boardgames.stream().filter(boardgame -> boardgame.getName().equals(name)).findFirst().get()));
	}
	
	

}
