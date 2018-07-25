package com.capgemini.jstk.boardbuddy.dto.mapper.impl;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardbuddy.dto.LevelDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.Level;

@Component
public class LevelMapper implements Mapper<Level, LevelDto> {

	@Override
	public LevelDto toDto(Level entity) {
		final LevelDto levelDto = new LevelDto(entity.getId());
		levelDto.setLevelValue(entity.getLevelValue());
		levelDto.setName(entity.getName());
		return levelDto;
	}

	@Override
	public Level toEntity(LevelDto dto) {
		return null;
	}
	
	

}
