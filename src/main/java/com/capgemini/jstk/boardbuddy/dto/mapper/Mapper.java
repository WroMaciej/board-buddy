package com.capgemini.jstk.boardbuddy.dto.mapper;

public interface Mapper<E, T> {
	
	public T toDto(E entity);
		
	public E toEntity(T dto);

}
