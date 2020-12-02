package com.diana.cookbook.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.diana.cookbook.model.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> {

}
