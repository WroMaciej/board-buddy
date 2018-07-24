package com.capgemini.jstk.boardbuddy.dto;

import lombok.Getter;
import lombok.Setter;

public class LevelDto {
	
	@Getter	@Setter
	private Integer id;
	@Getter	@Setter
	private Integer levelValue;
	@Getter	@Setter
	private String name;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((levelValue == null) ? 0 : levelValue.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		LevelDto other = (LevelDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (levelValue == null) {
			if (other.levelValue != null)
				return false;
		} else if (!levelValue.equals(other.levelValue))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
