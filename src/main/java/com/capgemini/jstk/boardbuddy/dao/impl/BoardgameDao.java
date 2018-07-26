package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardbuddy.dao.BoardgameDaoFacade;
import com.capgemini.jstk.boardbuddy.dao.impl.mock.CommonDatabaseMock;
import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.Boardgame;
import com.capgemini.jstk.boardbuddy.validation.ValidatorFacade;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

@Repository
public class BoardgameDao implements BoardgameDaoFacade {

	private Collection<Boardgame> boardgames;
	private Mapper<Boardgame, BoardgameDto> boardgameMapper;
	private ValidatorFacade<BoardgameDto> boardgameValidatorFacade;
	
	@Autowired
	public BoardgameDao(CommonDatabaseMock commonDatabaseMock, Mapper<Boardgame, BoardgameDto> boardgameMapper, ValidatorFacade<BoardgameDto> boardgameValidator) {
		this.boardgameMapper = boardgameMapper;
		this.boardgameValidatorFacade = boardgameValidator;
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
		boardgameValidatorFacade.validate(boardgameMapper.toDto(toAdd));
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
