package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardbuddy.dao.BoardgameDao;
import com.capgemini.jstk.boardbuddy.dao.UserBoardgameDao;
import com.capgemini.jstk.boardbuddy.dao.UserDao;
import com.capgemini.jstk.boardbuddy.dao.impl.mock.CommonDatabaseMock;
import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.dto.UserBoardgameCto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.UserBoardgame;

@Repository
public class UserBoardgameDaoImpl implements UserBoardgameDao {
	
	private CommonDatabaseMock commonDatabaseMock;
	
	private Mapper<UserBoardgame, UserBoardgameCto> userBoardgameMapper;
	
	private Collection<UserBoardgame> userBoardgames;
	
	private UserDao userDao;
	private BoardgameDao boardgameDao;
	
	
	@Autowired
	public UserBoardgameDaoImpl(CommonDatabaseMock commonDatabaseMock,
			Mapper<UserBoardgame, UserBoardgameCto> userBoardgameMapper, UserDao userDao, BoardgameDao boardgameDao) {
		this.commonDatabaseMock = commonDatabaseMock;
		this.userBoardgameMapper = userBoardgameMapper;
		this.userDao = userDao;
		this.boardgameDao = boardgameDao;
		userBoardgames = this.commonDatabaseMock.getUserBoardgames();
	}

	@Override
	public Collection<UserDto> findUsersByBoardgame(BoardgameDto boardgameDto) {
		return userBoardgames.stream().filter(userBoardgame -> userBoardgame.getBoardgameId().equals(boardgameDto.getId()))
				.map(userBoardgame -> userDao.findById(userBoardgame.getUserId()).get() )
				.collect(Collectors.toList());
	}

	@Override
	public Collection<BoardgameDto> findBoardgamesByUser(UserDto userDto) {
		return userBoardgames.stream().filter(userBoardgame -> userBoardgame.getUserId().equals(userDto.getId()))
				.map(userBoardgame -> boardgameDao.findById(userBoardgame.getBoardgameId()).get() )
				.collect(Collectors.toList());
	}



}
