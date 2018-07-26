package com.capgemini.jstk.boardbuddy.dao;


import java.util.Collection;

import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;

public interface User_BoardgameDao {
	
	public Collection<UserDto> findUsersByBoardgame(Integer  boardgameId);
	
	public Collection<BoardgameDto> findBoardgamesByUser(Integer boardgameId);

	public void addBoardgame(Integer requestingUserId, Integer boardgameId);

}
