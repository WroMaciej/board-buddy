package com.capgemini.jstk.boardbuddy.dao;

import java.util.Optional;

import com.capgemini.jstk.boardbuddy.dto.LevelDto;

public interface LevelDao {
	
	public Optional<LevelDto> findById(Integer id);
	
	public Optional<LevelDto> findByScore(Integer score);

}
