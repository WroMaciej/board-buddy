package com.capgemini.jstk.boardbuddy.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

	@Setter(AccessLevel.NONE)
	private final Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String lifeMotto;
	private Integer score;
	private Integer rankPosition;
	private Integer wins;
	private Integer losses;
	private Integer draws;
	private Integer levelValue;

	public UserDto(Integer id) {
		this.id = id;
	}

	public UserDto(Integer id, String firstName, String lastName, String email, String lifeMotto,
			Integer score, Integer rankPosition, Integer wins, Integer losses, Integer draws,
			Integer levelValue) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.lifeMotto = lifeMotto;
		this.score = score;
		this.rankPosition = rankPosition;
		this.wins = wins;
		this.losses = losses;
		this.draws = draws;
		this.levelValue = levelValue;
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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		UserDto other = (UserDto) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
