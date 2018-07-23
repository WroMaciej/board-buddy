package com.capgemini.jstk.boardbuddy.dao;

import java.util.Optional;

import com.capgemini.jstk.boardbuddy.entity.Level;

public interface LevelDao {
	
	public Optional<Level> findById(Integer id);
	
	public Optional<Level> findByScore(Integer score);

}
