package com.capgemini.jstk.boardbuddy.dao;

import java.util.Optional;

import com.capgemini.jstk.boardbuddy.dto.UserDto;

public interface UserDao {
	
	public Optional<UserDto> findById(Integer id);
	
	public Optional<Integer> findRankPosition(UserDto userDto);

}
