package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardbuddy.dao.LevelDaoFacade;
import com.capgemini.jstk.boardbuddy.dao.impl.mock.CommonDatabaseMock;
import com.capgemini.jstk.boardbuddy.dto.LevelDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.Level;

@Repository
public class LevelDao implements LevelDaoFacade{
	
private CommonDatabaseMock commonDatabaseMock;
	
private Collection<Level> levels;

private Mapper<Level, LevelDto> levelMapper;


	@Autowired
	public LevelDao(CommonDatabaseMock commonDatabaseMock, Mapper<Level, LevelDto> levelMapper) {
	this.commonDatabaseMock = commonDatabaseMock;
	this.levelMapper = levelMapper;
	levels = this.commonDatabaseMock.getLevels();
}

	@Override
	public Optional<LevelDto> findById(Integer id) {
		//Optional.ofNullable(userMapper.toDto(users.stream().filter(user -> user.getId().equals(id)).findFirst().get()));
		return Optional.ofNullable(levelMapper.toDto(levels.stream().filter(levels -> levels.getId().equals(id)).findFirst().get()));
	}

	@Override
	public Optional<LevelDto> findByScore(Integer score) {
		Collection<Level> lessOrEqualScoreLevel = levels.stream().filter(level -> level.getMinScore() <= score).collect(Collectors.toList());
		Level maxLevelFromLesserLevels = Collections.max(lessOrEqualScoreLevel, Comparator.comparing(Level::getMinScore));
		return Optional.ofNullable(levelMapper.toDto(maxLevelFromLesserLevels)); //null is not accepted
	}
	

}
