package com.diana.cookbook.service;

import java.util.List;

import com.diana.cookbook.model.AbstractIdentifiable;

public interface CrudService<E extends AbstractIdentifiable> {

	public E findById(Long id);
	
	public List<E> getAll();
	
	public E save(E entity);
	
	public void deleteById(Long id);
	
	public void deleteByEntity(E entity);
	
}
