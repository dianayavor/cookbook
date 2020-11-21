package com.diana.cookbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diana.cookbook.model.Menu;
import com.diana.cookbook.repository.MenuRepository;

@Service
public class MenuService implements CrudService<Menu>{
	
	private MenuRepository menuRepository;
	
	@Autowired
	public MenuService(MenuRepository menuRepository) {
		super();
		this.menuRepository = menuRepository;
	}

	@Override
	public Menu findById(Long id) {
		return menuRepository.findById(id).get();
	}

	@Override
	public List<Menu> getAll() {
		List<Menu> menus = new ArrayList<Menu>();
		menuRepository.findAll().forEach(menus::add);
		return menus;
	}

	@Override
	public Menu save(Menu menu) {
		return menuRepository.save(menu);
	}

	@Override
	public void deleteById(Long id) {
		menuRepository.deleteById(id);
	}

	@Override
	public void deleteByEntity(Menu menu) {
		menuRepository.delete(menu);
	}

}
