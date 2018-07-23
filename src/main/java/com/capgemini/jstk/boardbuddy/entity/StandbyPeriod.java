package com.capgemini.jstk.boardbuddy.entity;

import java.util.Calendar;

/**
 * Availibility period for game
 * @author MACIEWRO
 *
 */
public class StandbyPeriod {

	private Integer id;
	private Integer userId;
	
	private Calendar startDate;
	private Calendar endDate;
	
	private String comment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
