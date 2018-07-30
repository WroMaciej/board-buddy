package com.capgemini.jstk.boardbuddy.dto;

import java.util.Calendar;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandbyPeriodDto {

	@Setter(AccessLevel.NONE)
	private final Integer id;
	private Integer userId;
	private Calendar startDate;
	private Calendar endDate;
	private String comment;
	private boolean isActive;

	public StandbyPeriodDto(Integer id) {
		this.id = id;
	}
	
	public StandbyPeriodDto(Integer id, Integer userId, Calendar startDate, Calendar endDate,
			String comment, boolean isActive) {
		super();
		this.id = id;
		this.userId = userId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.comment = comment;
		this.isActive = isActive;
	}
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		StandbyPeriodDto other = (StandbyPeriodDto) obj;
		if (endDate == null) {
			if (other.endDate != null) {
				return false;
			}
		} else if (!endDate.equals(other.endDate)) {
			return false;
		}
		if (startDate == null) {
			if (other.startDate != null) {
				return false;
			}
		} else if (!startDate.equals(other.startDate)) {
			return false;
		}
		return true;
	}




}
