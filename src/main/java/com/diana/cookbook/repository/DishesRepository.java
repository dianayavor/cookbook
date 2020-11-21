package com.diana.cookbook.repository;

import org.springframework.data.repository.CrudRepository;

import com.diana.cookbook.model.Dishes;

public interface DishesRepository extends CrudRepository<Dishes, Long>{

}
