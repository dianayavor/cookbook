package com.diana.cookbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diana.cookbook.model.Meal;
import com.diana.cookbook.repository.MealRepository;

@Service
public class MealService implements CrudService<Meal>{
	
	private MealRepository mealRepository;
	
	@Autowired
	public MealService(MealRepository mealRepository) {
		super();
		this.mealRepository = mealRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public Meal findById(Long id) {
		return mealRepository.findById(id).get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Meal> getAll() {
		List<Meal> meals = new ArrayList<Meal>();
		mealRepository.findAll().forEach(meals::add);
		return meals;
	}

	@Override
	public Meal save(Meal meal) {
		return mealRepository.save(meal);
	}

	@Override
	public void deleteById(Long id) {
		mealRepository.deleteById(id);
	}

	@Override
	public void deleteByEntity(Meal meal) {
		mealRepository.delete(meal);		
	}

}
