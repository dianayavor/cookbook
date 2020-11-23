package com.diana.cookbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diana.cookbook.model.MenuItem;
import com.diana.cookbook.service.MenuItemService;

@RestController
@RequestMapping("/menuItem")
public class MenuItemController {

	private MenuItemService menuItemService;

	@Autowired
	public MenuItemController(MenuItemService menuItemService) {
		super();
		this.menuItemService = menuItemService;
	}
	
	@GetMapping("{id}")
	public ResponseEntity<MenuItem> getMenuItem(@PathVariable("id") Long id) {
		return ResponseEntity.ok(menuItemService.findById(id));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<MenuItem>> getMenuItems() {
		return ResponseEntity.ok(menuItemService.getAll());
	}
	
	@PostMapping("/save")
	public ResponseEntity<MenuItem> saveMenuItem(@RequestBody MenuItem menuItem) {
		return ResponseEntity.ok(menuItemService.save(menuItem));
	}
	
	
}
