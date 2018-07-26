package com.capgemini.jstk.boardbuddy.dao;

import java.util.Optional;

import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

public interface BoardgameDaoFacade {
	
	public Optional<BoardgameDto> findById(Integer id);
	
	public Optional<BoardgameDto> findByName(String name);

	public void addBoardgame(BoardgameDto boardgameDto) throws IllegalOperationException;
}
