package com.diana.cookbook.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diana.cookbook.model.MenuItem;

@Repository
public interface MenuItemRepository extends CrudRepository<MenuItem, Long>{

}
