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

import com.diana.cookbook.model.Menu;
import com.diana.cookbook.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuConroller {
	private MenuService menuService;

	@Autowired
	public MenuConroller(MenuService menuService) {
		super();
		this.menuService = menuService;
	}

	@GetMapping("{id}")
	public ResponseEntity<Menu> getMenu(@PathVariable("id") Long id) {
		return ResponseEntity.ok(menuService.findById(id));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Menu>> getMenus() {
		return ResponseEntity.ok(menuService.getAll());
	}

	@PostMapping("/save")
	public ResponseEntity<Menu> saveMenu(@RequestBody Menu menu) {
		return ResponseEntity.ok(menuService.save(menu));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteMenu(@PathVariable("id") Long id) {
		menuService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
