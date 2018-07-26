package com.capgemini.jstk.boardbuddy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jstk.boardbuddy.dao.BoardgameDaoFacade;
import com.capgemini.jstk.boardbuddy.dao.User_BoardgameDaoFacade;
import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.service.BoardgameServiceFacade;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

@Service
public class BoardgameService implements BoardgameServiceFacade {
	
	private BoardgameDaoFacade boardgameDaoFacade;
	private User_BoardgameDaoFacade user_BoardgameDaoFacade;
	
	
	
	@Autowired
	public BoardgameService(BoardgameDaoFacade boardgameDaoFacade, User_BoardgameDaoFacade user_BoardgameDaoFacade) {
		this.boardgameDaoFacade = boardgameDaoFacade;
		this.user_BoardgameDaoFacade = user_BoardgameDaoFacade;
	}

	@Override
	public boolean isBoardgameInDatabase(String boardgameName) {
		return boardgameDaoFacade.findByName(boardgameName).isPresent();
	}
	
	@Override
	public boolean hasUserBoardgame(Integer userId, String boardgameName) {
		if (!isBoardgameInDatabase(boardgameName)) return false;
		return user_BoardgameDaoFacade.findBoardgamesByUser(userId).stream().anyMatch(game -> game.getName().equals(boardgameName));
	}
	
	@Override
	public void addBoardgame(Integer requestingUserId, BoardgameDto boardgameDto) throws IllegalOperationException {
		if (!isBoardgameInDatabase(boardgameDto.getName())) {
			boardgameDaoFacade.addBoardgame(boardgameDto);
		}
		if (hasUserBoardgame(requestingUserId, boardgameDto.getName())) {
			throw new IllegalOperationException("User already has that game");
		}
		Integer boardgameId = boardgameDaoFacade.findByName(boardgameDto.getName()).get().getId();
		user_BoardgameDaoFacade.addBoardgame(requestingUserId, boardgameId);
	}

}
