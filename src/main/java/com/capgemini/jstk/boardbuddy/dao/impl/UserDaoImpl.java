package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardbuddy.dao.UserDao;
import com.capgemini.jstk.boardbuddy.dto.UserDto;
import com.capgemini.jstk.boardbuddy.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
private static List<User> users;
	
	@Override
	public Optional<User> findById(Integer id) {
		return users.stream().filter(user -> user.getId().equals(id)).findFirst();
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
	}

	@Override
	public Optional<Integer> findRankPosition(User user) {
		//TODO think about improve this implementation
		List<User> sortedByScore = new ArrayList<>();
		sortedByScore.addAll(users);
		sortedByScore.sort((user1, user2) -> user1.getScore() - user2.getScore() );
		Integer rankPosition = sortedByScore.indexOf(user);
		return Optional.of(rankPosition);
	}

	

}
