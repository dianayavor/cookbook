package com.diana.cookbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diana.cookbook.model.MenuItem;
import com.diana.cookbook.repository.MenuItemRepository;

@Service
public class MenuItemService implements CrudService<MenuItem>{
	
	private MenuItemRepository menuItemRepository;
	
	@Autowired
	public MenuItemService(MenuItemRepository menuItemRepository) {
		this.menuItemRepository = menuItemRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public MenuItem findById(Long id) {
		return menuItemRepository.findById(id).get();
	}

	@Override
	@Transactional(readOnly = true)
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
