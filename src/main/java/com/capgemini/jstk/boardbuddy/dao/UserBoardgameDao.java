package com.capgemini.jstk.boardbuddy.dao;


import java.util.List;

import com.capgemini.jstk.boardbuddy.entity.Boardgame;
import com.capgemini.jstk.boardbuddy.entity.User;

public interface UserBoardgameDao {
	
	public List<User> findUsersByBoardgame(Boardgame boardgame, UserDao userDao);
	
	public List<Boardgame> findBoardgamesByUser(User user, BoardgameDao boardgameDao);

}
