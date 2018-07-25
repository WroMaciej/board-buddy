package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardbuddy.dao.BoardgameDao;
import com.capgemini.jstk.boardbuddy.dao.User_BoardgameDao;
import com.capgemini.jstk.boardbuddy.dao.UserDao;
import com.capgemini.jstk.boardbuddy.dao.impl.mock.CommonDatabaseMock;
import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.dto.User_Boardgame_Cto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.User_Boardgame_X;

@Repository
public class UserBoardgameDaoImpl implements User_BoardgameDao {
	
	
	private Collection<User_Boardgame_X> user_Boardgame_Xs;
	
	private UserDao userDao;
	private BoardgameDao boardgameDao;
	
	
	@Autowired
	public UserBoardgameDaoImpl(CommonDatabaseMock commonDatabaseMock,
			Mapper<User_Boardgame_X, User_Boardgame_Cto> user_Boardgame_XMapper, UserDao userDao, BoardgameDao boardgameDao) {
		this.userDao = userDao;
		this.boardgameDao = boardgameDao;
		user_Boardgame_Xs = commonDatabaseMock.getUser_Boardgame_Xs();
	}

	@Override
	public Collection<UserDto> findUsersByBoardgame(BoardgameDto boardgameDto) {
		return user_Boardgame_Xs.stream().filter(userBoardgame -> userBoardgame.getBoardgameId().equals(boardgameDto.getId()))
				.map(userBoardgame -> userDao.findById(userBoardgame.getUserId()).get() )
				.collect(Collectors.toList());
	}

	@Override
	public Collection<BoardgameDto> findBoardgamesByUser(UserDto userDto) {
		return user_Boardgame_Xs.stream().filter(userBoardgame -> userBoardgame.getUserId().equals(userDto.getId()))
				.map(userBoardgame -> boardgameDao.findById(userBoardgame.getBoardgameId()).get() )
				.collect(Collectors.toList());
	}



}
