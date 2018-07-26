package com.capgemini.jstk.boardbuddy.service;

import com.capgemini.jstk.boardbuddy.dto.BoardgameDto;
import com.capgemini.jstk.boardbuddy.validation.exceptions.IllegalOperationException;

public interface BoardgameServiceFacade {

	boolean isBoardgameInDatabase(String boardgameName);

	boolean hasUserBoardgame(Integer userId, String boardgameName);

	void addBoardgame(Integer requestingUserId, BoardgameDto boardgameDto) throws IllegalOperationException;

}
