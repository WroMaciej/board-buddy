package com.capgemini.jstk.boardbuddy.dao.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoImplTest {

	
	@Autowired
	private UserDaoImpl userDaoImpl;

	@Test
	public void testFindById() {
		// given
		userDaoImpl.findById(1);

		// when

		// then
	}
}
