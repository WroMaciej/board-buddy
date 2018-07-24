package com.capgemini.jstk.boardbuddy.dao;


import java.util.Collection;

import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;

public interface UserBoardgameDao {
	
	public Collection<UserDto> findUsersByBoardgame(BoardgameDto boardgameDto);
	
	public Collection<BoardgameDto> findBoardgamesByUser(UserDto userDto);

}
