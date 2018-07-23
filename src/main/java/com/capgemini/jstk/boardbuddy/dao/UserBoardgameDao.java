package com.capgemini.jstk.boardbuddy.dao;


import java.util.List;

import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.entity.Boardgame;
import com.capgemini.jstk.boardbuddy.entity.User;

public interface UserBoardgameDao {
	
	public List<UserDto> findUsersByBoardgame(Boardgame boardgame, UserDao userDao);
	
	public List<BoardgameDto> findBoardgamesByUser(User user, BoardgameDao boardgameDao);

}
