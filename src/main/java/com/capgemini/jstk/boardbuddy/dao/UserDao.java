package com.capgemini.jstk.boardbuddy.dao;

import java.util.List;
import java.util.Optional;

import com.capgemini.jstk.boardbuddy.dto.UserDto;

public interface UserDao {

	public Optional<UserDto> findById(Integer id);

	public List<UserDto> findAllUsers();

	public void updateProfile(Integer userId, UserDto updatedUserDto);

}
