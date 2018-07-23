package com.capgemini.jstk.boardbuddy.dao;

import java.util.Optional;

import com.capgemini.jstk.boardbuddy.entity.Boardgame;

public interface BoardgameDao {
	
	public Optional<Boardgame> findById(Integer id);
	
	public Optional<Boardgame> findByName(String name);

}
