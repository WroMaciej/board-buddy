package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardbuddy.dao.BoardgameDao;
import com.capgemini.jstk.boardbuddy.dao.impl.mock.CommonDatabaseMock;
import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.Boardgame;
import com.capgemini.jstk.boardbuddy.validation.Validator;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

@Repository
public class BoardgameDaoImpl implements BoardgameDao {

	private Collection<Boardgame> boardgames;
	private Mapper<Boardgame, BoardgameDto> boardgameMapper;
	private Validator<BoardgameDto> boardgameValidator;
	
	@Autowired
	public BoardgameDaoImpl(CommonDatabaseMock commonDatabaseMock, Mapper<Boardgame, BoardgameDto> boardgameMapper, Validator<BoardgameDto> boardgameValidator) {
		this.boardgameMapper = boardgameMapper;
		this.boardgameValidator = boardgameValidator;
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

	@Override
	public void addBoardgame(BoardgameDto boardgameDto) throws IllegalOperationException {
		Boardgame toAdd = new Boardgame(getUniqueId(), boardgameDto.getName());
		boardgameValidator.validate(boardgameMapper.toDto(toAdd));
		boardgames.add(toAdd);
	}
	
	private Integer getUniqueId() {
		Integer maxId = Integer.valueOf(0);
		for (Boardgame boardgame : boardgames) {
			if (boardgame.getId() > maxId) {
				maxId = boardgame.getId();
			}
		}
		return Integer.valueOf(maxId + 1);		
	}
	
	

}
