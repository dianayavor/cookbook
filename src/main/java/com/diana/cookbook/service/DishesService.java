package com.diana.cookbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diana.cookbook.model.Dishes;
import com.diana.cookbook.repository.DishesRepository;

@Service
public class DishesService implements CrudService<Dishes>{
	
	private DishesRepository dishesRepository;
	
	@Autowired
	public DishesService(DishesRepository dishesRepository) {
		super();
		this.dishesRepository = dishesRepository;
	}

	@Override
	public Dishes findById(Long id) {
		return dishesRepository.findById(id).get();
	}

	@Override
	public List<Dishes> getAll() {
		List<Dishes> dishes = new ArrayList<>();
		dishesRepository.findAll().forEach(dishes::add);
		return dishes;
	}

	@Override
	public Dishes save(Dishes dishes) {
		return dishesRepository.save(dishes);
	}

	@Override
	public void deleteById(Long id) {
		dishesRepository.deleteById(id);
	}

	@Override
	public void deleteByEntity(Dishes dishes) {
		dishesRepository.delete(dishes);
	}

}
