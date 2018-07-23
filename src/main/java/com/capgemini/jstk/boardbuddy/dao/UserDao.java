package com.capgemini.jstk.boardbuddy.dao;

import java.util.Optional;

import com.capgemini.jstk.boardbuddy.entity.User;

public interface UserDao {
	
	public Optional<User> findById(Integer id);
	
	public Optional<User> findByEmail(String email);

}
