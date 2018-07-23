package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardbuddy.dao.LevelDao;
import com.capgemini.jstk.boardbuddy.entity.Level;

@Repository
public class LevelDaoImpl implements LevelDao{
	
private static Collection<Level> levels;
	
	@Override
	public Optional<Level> findById(Integer id) {
		return levels.stream().filter(levels -> levels.getId().equals(id)).findFirst();
	}

}
