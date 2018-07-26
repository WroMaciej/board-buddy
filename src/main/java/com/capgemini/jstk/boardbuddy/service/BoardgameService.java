package com.capgemini.jstk.boardbuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jstk.boardbuddy.dao.BoardgameDao;
import com.capgemini.jstk.boardbuddy.dao.User_BoardgameDao;
import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

@Service
public class BoardgameService {
	
	private BoardgameDao boardgameDao;
	private User_BoardgameDao user_BoardgameDao;
	
	
	
	@Autowired
	public BoardgameService(BoardgameDao boardgameDao, User_BoardgameDao user_BoardgameDao) {
		this.boardgameDao = boardgameDao;
		this.user_BoardgameDao = user_BoardgameDao;
	}

	public boolean isBoardgameInDatabase(String boardgameName) {
		return boardgameDao.findByName(boardgameName).isPresent();
	}
	
	public boolean hasUserBoardgame(Integer userId, String boardgameName) {
		if (!isBoardgameInDatabase(boardgameName)) return false;
		return user_BoardgameDao.findBoardgamesByUser(userId).stream().anyMatch(game -> game.getName().equals(boardgameName));
	}
	
	public void addBoardgame(Integer requestingUserId, BoardgameDto boardgameDto) throws IllegalOperationException {
		if (!isBoardgameInDatabase(boardgameDto.getName())) {
			boardgameDao.addBoardgame(boardgameDto);
		}
	}

}
