package com.diana.cookbook.repository;

import org.springframework.data.repository.CrudRepository;

import com.diana.cookbook.model.Meal;

public interface MealRepository extends CrudRepository<Meal, Long> {

}
