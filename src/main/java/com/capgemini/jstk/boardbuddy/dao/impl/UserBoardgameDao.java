package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardbuddy.dao.BoardgameDaoFacade;
import com.capgemini.jstk.boardbuddy.dao.UserDaoFacade;
import com.capgemini.jstk.boardbuddy.dao.User_BoardgameDaoFacade;
import com.capgemini.jstk.boardbuddy.dao.impl.mock.CommonDatabaseMock;
import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.dto.User_Boardgame_Cto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.User_Boardgame_X;

@Repository
public class UserBoardgameDao implements User_BoardgameDaoFacade {
	
	
	private Collection<User_Boardgame_X> user_Boardgame_Xs;
	
	private UserDaoFacade userDaoFacade;
	private BoardgameDaoFacade boardgameDaoFacade;
	
	
	@Autowired
	public UserBoardgameDao(CommonDatabaseMock commonDatabaseMock,
			Mapper<User_Boardgame_X, User_Boardgame_Cto> user_Boardgame_XMapper, UserDaoFacade userDaoFacade, BoardgameDaoFacade boardgameDaoFacade) {
		this.userDaoFacade = userDaoFacade;
		this.boardgameDaoFacade = boardgameDaoFacade;
		user_Boardgame_Xs = commonDatabaseMock.getUser_Boardgame_Xs();
	}

	@Override
	public Collection<UserDto> findUsersByBoardgame(Integer boardgameId) {
		return user_Boardgame_Xs.stream().filter(userBoardgame -> userBoardgame.getBoardgameId().equals(boardgameId))
				.map(userBoardgame -> userDaoFacade.findById(userBoardgame.getUserId()).get() )
				.collect(Collectors.toList());
	}

	@Override
	public Collection<BoardgameDto> findBoardgamesByUser(Integer userId) {
		return user_Boardgame_Xs.stream().filter(userBoardgame -> userBoardgame.getUserId().equals(userId))
				.map(userBoardgame -> boardgameDaoFacade.findById(userBoardgame.getBoardgameId()).get() )
				.collect(Collectors.toList());
	}

	@Override
	public void addBoardgame(Integer ownerUserId, Integer boardgameId) {
		user_Boardgame_Xs.add(new User_Boardgame_X(getUniqueId(), ownerUserId, boardgameId));
	}
	
	private Integer getUniqueId() {
		Integer maxId = Integer.valueOf(0);
		for (User_Boardgame_X join : user_Boardgame_Xs) {
			if (join.getId() > maxId) {
				maxId = join.getId();
			}
		}
		return Integer.valueOf(maxId + 1);		
	}



}
