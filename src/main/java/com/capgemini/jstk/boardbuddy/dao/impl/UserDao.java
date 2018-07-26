package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardbuddy.dao.UserDaoFacade;
import com.capgemini.jstk.boardbuddy.dao.impl.mock.CommonDatabaseMock;
import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.dto.mapper.Mapper;
import com.capgemini.jstk.boardbuddy.entity.User;
import com.capgemini.jstk.boardbuddy.validation.exceptions.NoSuchElementInDatabaseException;

@Repository
public class UserDao implements UserDaoFacade {

	private Mapper<User, UserDto> userMapper;

	private Collection<User> users;

	@Autowired
	public UserDao(CommonDatabaseMock commonDatabaseMock, Mapper<User, UserDto> userMapper) {
		this.userMapper = userMapper;
		users = commonDatabaseMock.getUsers();
	}

	@Override
	public Optional<UserDto> findById(Integer id) {
		return Optional
				.ofNullable(userMapper.toDto(users.stream().filter(user -> user.getId().equals(id)).findFirst().get()));
	}

	@Override
	public List<UserDto> findAllUsers() {
		List<UserDto> userDtos = new ArrayList<>();
		users.forEach(user -> userDtos.add(userMapper.toDto(user)));
		return userDtos;
	}

	@Override
	public void updateProfile(Integer userId, UserDto updatedUserDto) {
		User userBO = getUserFromDatabase(userId);
		userBO.setEmail(updatedUserDto.getEmail());
		userBO.setFirstName(updatedUserDto.getFirstName());
		userBO.setLastName(updatedUserDto.getLastName());
		userBO.setLifeMotto(updatedUserDto.getLifeMotto());

	}
	
	private User getUserFromDatabase(Integer userId) {
		Optional<User> searchingUser = users.stream().filter(user -> user.getId().equals(userId)).findFirst();
		if (!searchingUser.isPresent()) {
			throw new NoSuchElementInDatabaseException("User to be updated does not exist! User ID: " + userId);
		}
		return searchingUser.get();
	}

}
