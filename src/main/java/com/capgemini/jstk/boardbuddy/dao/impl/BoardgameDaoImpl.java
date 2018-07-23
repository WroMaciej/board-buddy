package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardbuddy.dao.BoardgameDao;
import com.capgemini.jstk.boardbuddy.entity.Boardgame;
import com.capgemini.jstk.boardbuddy.entity.User;

@Repository
public class BoardgameDaoImpl implements BoardgameDao {

	private static Collection<Boardgame> boardgames;
	
	@Override
	public Optional<Boardgame> findById(Integer id) {
		return boardgames.stream().filter(boardgame -> boardgame.getId().equals(id)).findFirst();
	}

	@Override
	public Optional<Boardgame> findByName(String name) {
		return boardgames.stream().filter(boardgame -> boardgame.getName().equals(name)).findFirst();
	}
	
	

}
