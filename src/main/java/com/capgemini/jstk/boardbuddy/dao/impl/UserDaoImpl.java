package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardbuddy.dao.UserDao;
import com.capgemini.jstk.boardbuddy.entity.Boardgame;
import com.capgemini.jstk.boardbuddy.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
private static Collection<User> users;
	
	@Override
	public Optional<User> findById(Integer id) {
		return users.stream().filter(user -> user.getId().equals(id)).findFirst();
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
	}
	

}
