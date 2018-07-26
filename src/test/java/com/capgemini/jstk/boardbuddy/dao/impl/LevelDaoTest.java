package com.capgemini.jstk.boardbuddy.dao.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jstk.boardbuddy.dao.LevelDaoFacade;
import com.capgemini.jstk.boardbuddy.dto.LevelDto;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LevelDaoTest {
	
	@Autowired
	private LevelDaoFacade levelDaoFacade;
	


	@Test
	public void testFindById() {
		// when
		LevelDto levelDto = levelDaoFacade.findById(2).get();
		// then
		assertEquals(Integer.valueOf(5), levelDto.getLevelValue());	
	}
	
	@Test
	public void testFindByScore() {
		//given
		String levelNameFor1601score = "Master";
		// when
		LevelDto levelDto = levelDaoFacade.findByScore(Integer.valueOf(1601)).get();
		// then
		assertEquals(levelNameFor1601score, levelDto.getName());	
	}

}
