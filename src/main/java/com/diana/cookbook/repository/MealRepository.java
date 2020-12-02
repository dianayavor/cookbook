package com.diana.cookbook.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diana.cookbook.model.Meal;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {

}
