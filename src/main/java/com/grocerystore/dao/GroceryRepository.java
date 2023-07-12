package com.grocerystore.dao;

import org.springframework.data.repository.CrudRepository;

import com.grocerystore.dto.GroceryDTO;

public interface GroceryRepository extends CrudRepository<GroceryDTO, Integer> {

}
