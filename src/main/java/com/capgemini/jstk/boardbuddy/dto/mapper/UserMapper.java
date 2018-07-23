package com.capgemini.jstk.boardbuddy.dto.mapper;

import java.util.Optional;

import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.entity.User;

public class UserMapper implements Mapper<User, Optional<UserDto>> {

	@Override
	public Optional<UserDto> toDto(User entity) {
		final UserDto userDto = new UserDto();
		userDto.setId(entity.getId());
		userDto.setFirstName(entity.getFirstName());
		userDto.setLastName(entity.getLastName());
		userDto.setEmail(entity.getEmail());
		userDto.setScore(entity.getScore());
		userDto.setLifeMotto(entity.getLifeMotto());
		return Optional.of(userDto);
	}

	@Override
	public User toEntity(Optional<UserDto> dto) {
		return null;
	}
	
	

}
