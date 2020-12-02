package com.diana.cookbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diana.cookbook.model.User;
import com.diana.cookbook.repository.UserRepository;

@Service
public class UserService implements CrudService<User> {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public void deleteByEntity(User user) {
		userRepository.delete(user);
	}

}
