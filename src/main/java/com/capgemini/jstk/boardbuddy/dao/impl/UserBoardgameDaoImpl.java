package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.jstk.boardbuddy.dao.BoardgameDao;
import com.capgemini.jstk.boardbuddy.dao.UserBoardgameDao;
import com.capgemini.jstk.boardbuddy.dao.UserDao;
import com.capgemini.jstk.boardbuddy.entity.Boardgame;
import com.capgemini.jstk.boardbuddy.entity.User;
import com.capgemini.jstk.boardbuddy.entity.UserBoardgame;

public class UserBoardgameDaoImpl implements UserBoardgameDao {
	
	private static List<UserBoardgame> userBoardgames;

	@Override
	public List<User> findUsersByBoardgame(Boardgame boardgame, UserDao userDao) {
		return userBoardgames.stream().filter(userBoardgame -> userBoardgame.getBoardgameId().equals(boardgame.getId()))
				.map(userBoardgame -> userDao.findById(userBoardgame.getUserId()).get() )
				.collect(Collectors.toList());
	}

	@Override
	public List<Boardgame> findBoardgamesByUser(User user, BoardgameDao boardgameDao) {
		return userBoardgames.stream().filter(userBoardgame -> userBoardgame.getUserId().equals(user.getId()))
				.map(userBoardgame -> boardgameDao.findById(userBoardgame.getBoardgameId()).get() )
				.collect(Collectors.toList());
	}



}
