package com.capgemini.jstk.boardbuddy.dao;

import java.util.Optional;

import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;

public interface BoardgameDao {
	
	public Optional<BoardgameDto> findById(Integer id);
	
	public Optional<BoardgameDto> findByName(String name);

}
