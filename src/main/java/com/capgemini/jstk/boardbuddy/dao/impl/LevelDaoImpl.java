package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

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

	@Override
	public Optional<Level> findByScore(Integer score) {
		Collection<Level> lessOrEqualScoreLevel = levels.stream().filter(level -> level.getMinScore() <= score).collect(Collectors.toList());
		Level maxLevelFromLesserLevels = Collections.max(lessOrEqualScoreLevel, Comparator.comparing(Level::getMinScore));
		return Optional.of(maxLevelFromLesserLevels); //null is not accepted
	}
	

}
