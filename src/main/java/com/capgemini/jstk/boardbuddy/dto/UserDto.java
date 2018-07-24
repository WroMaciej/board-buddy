package com.capgemini.jstk.boardbuddy.dto;

import lombok.Getter;
import lombok.Setter;

public class UserDto {
		
	@Getter	@Setter
	private Integer id;
	@Getter	@Setter
	private String firstName;
	@Getter	@Setter
	private String lastName;
	@Getter	@Setter
	private String email;
	@Getter	@Setter
	private String lifeMotto;
	@Getter	@Setter
	private Integer score;
	
	@Getter	@Setter
	private Integer rankPosition;
	@Getter	@Setter
	private Integer levelValue;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((levelValue == null) ? 0 : levelValue.hashCode());
		result = prime * result + ((lifeMotto == null) ? 0 : lifeMotto.hashCode());
		result = prime * result + ((rankPosition == null) ? 0 : rankPosition.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
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
		UserDto other = (UserDto) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (levelValue == null) {
			if (other.levelValue != null)
				return false;
		} else if (!levelValue.equals(other.levelValue))
			return false;
		if (lifeMotto == null) {
			if (other.lifeMotto != null)
				return false;
		} else if (!lifeMotto.equals(other.lifeMotto))
			return false;
		if (rankPosition == null) {
			if (other.rankPosition != null)
				return false;
		} else if (!rankPosition.equals(other.rankPosition))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		return true;
	}
	
	
		

}
