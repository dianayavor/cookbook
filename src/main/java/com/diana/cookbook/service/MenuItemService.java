package com.diana.cookbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.support.DefaultCrudMethods;
import org.springframework.stereotype.Service;

import com.diana.cookbook.model.MenuItem;
import com.diana.cookbook.repository.MenuItemRepository;

@Service
public class MenuItemService implements CrudService<MenuItem>{
	
	private MenuItemRepository menuItemRepository;
	
	@Autowired
	public MenuItemService(MenuItemRepository menuItemRepository) {
		super();
		this.menuItemRepository = menuItemRepository;
	}

	@Override
	public MenuItem findById(Long id) {
		return menuItemRepository.findById(id).get();
	}

	@Override
	public List<MenuItem> getAll() {
		List<MenuItem> menuItems = new ArrayList<>();
		menuItemRepository.findAll().forEach(menuItems::add);
		return menuItems;
	}

	@Override
	public MenuItem save(MenuItem menuItem) {
		return menuItemRepository.save(menuItem);
	}

	@Override
	public void deleteById(Long id) {
		menuItemRepository.deleteById(id);
	}

	@Override
	public void deleteByEntity(MenuItem menuItem) {
		menuItemRepository.delete(menuItem);
	}

}
