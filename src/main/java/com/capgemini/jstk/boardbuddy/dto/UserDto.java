package com.capgemini.jstk.boardbuddy.dto;

import lombok.Getter;
import lombok.Setter;

public class UserDto {
		
	private final Integer id;
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
	private Integer wins;
	@Getter	@Setter
	private Integer losses;
	@Getter	@Setter
	private Integer draws;
	@Getter	@Setter
	private Integer levelValue;
	
	
	public UserDto(Integer id) {
		this.id = id;
	}
	
	public UserDto(UserDto idSource) {
		this.id = idSource.id;
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
		UserDto other = (UserDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	

	
	
	
	
	
		

}
