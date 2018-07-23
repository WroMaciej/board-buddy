package com.capgemini.jstk.boardbuddy.dao;

import java.util.Optional;

import com.capgemini.jstk.boardbuddy.entity.StandbyPeriod;

public interface StandbyPeriodDao {
	
	public Optional<StandbyPeriod> findById(Integer id);

}
