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

import com.diana.cookbook.model.Dishes;
import com.diana.cookbook.service.DishesService;

@RestController
@RequestMapping("/dishes")
public class DishesController {
	private DishesService dishesService;

	@Autowired
	public DishesController(DishesService dishesService) {
		super();
		this.dishesService = dishesService;
	}

	@GetMapping("{id}")
	public ResponseEntity<Dishes> getDishes(@PathVariable("id") Long id) {
		return ResponseEntity.ok(dishesService.findById(id));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Dishes>> getAllDishes() {
		return ResponseEntity.ok(dishesService.getAll());
	}

	@PostMapping("/save")
	public ResponseEntity<Dishes> saveDishes(@RequestBody Dishes dishes) {
		return ResponseEntity.ok(dishesService.save(dishes));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteDishes(@PathVariable("id") Long id) {
		dishesService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
