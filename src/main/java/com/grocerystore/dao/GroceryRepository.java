package com.grocerystore.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.grocerystore.dto.GroceryDTO;

public interface GroceryRepository extends CrudRepository<GroceryDTO, Integer> {

	List<GroceryDTO> findByItemId(int itemId);
}
