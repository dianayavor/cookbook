package com.diana.cookbook.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diana.cookbook.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
