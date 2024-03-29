package com.capgemini.jstk.boardbuddy.dto.mapper.impl;

import org.springframework.stereotype.Component;

import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.User;

@Component
public class UserMapper implements Mapper<User, UserDto> {

	@Override
	public UserDto toDto(User entity) {
		final UserDto userDto = new UserDto(entity.getId());
		userDto.setFirstName(entity.getFirstName());
		userDto.setLastName(entity.getLastName());
		userDto.setEmail(entity.getEmail());
		userDto.setScore(entity.getScore());
		userDto.setLifeMotto(entity.getLifeMotto());
		userDto.setWins(entity.getWins());
		userDto.setLosses(entity.getLosses());
		userDto.setDraws(entity.getDraws());
		return userDto;
	}

	@Override
	public User toEntity(UserDto dto) {
		return null;
	}
	
	

}
