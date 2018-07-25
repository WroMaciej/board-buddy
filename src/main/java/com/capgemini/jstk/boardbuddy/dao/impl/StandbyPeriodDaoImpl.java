package com.capgemini.jstk.boardbuddy.dao.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.capgemini.jstk.boardbuddy.dao.StandbyPeriodDao;
import com.capgemini.jstk.boardbuddy.entity.StandbyPeriod;

@Repository
public class StandbyPeriodDaoImpl implements StandbyPeriodDao {

private static Collection<StandbyPeriod> standbyPeriods;
	
	@Override
	public Optional<StandbyPeriod> findById(Integer id) {
		return standbyPeriods.stream().filter(standbyPeriod -> standbyPeriod.getId().equals(id)).findFirst();
	}
}
