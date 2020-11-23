package com.diana.cookbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diana.cookbook.model.Meal;
import com.diana.cookbook.service.MealService;

@RestController
@RequestMapping("/meal")
public class MealController {
	private MealService mealService;

	@Autowired
	public MealController(MealService mealService) {
		super();
		this.mealService = mealService;
	}

	@GetMapping("{id}")
	public ResponseEntity<Meal> getMeal(@PathVariable("id") Long id) {
		return ResponseEntity.ok(mealService.findById(id));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Meal>> getMeals() {
		return ResponseEntity.ok(mealService.getAll());
	}

	@PostMapping("/save")
	public ResponseEntity<Meal> saveMeal(@RequestBody Meal meal) {
		return ResponseEntity.ok(mealService.save(meal));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteMeal(@PathVariable("id") Long id) {
		mealService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
