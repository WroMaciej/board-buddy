package com.capgemini.jstk.boardbuddy.dto;

import java.util.Calendar;

import lombok.Getter;
import lombok.Setter;

public class ChallengeResultDto {
	
	private final Integer id;
	@Getter @Setter
	private BoardgameDto boardgameDto;
	@Getter	@Setter
	private Calendar dateOfStart;
	@Getter	@Setter
	private Calendar dateOfEnd;
	
	public ChallengeResultDto(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChallengeResultDto other = (ChallengeResultDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
