package com.grocerystore.service;

import java.util.List;

import com.grocerystore.dto.GroceryDTO;

/**
 * CRUD operations for grocery.
 * @author anastasiiaefimova
 *
 */
public interface IGroceryService {

	/**
	 * Get grocery from persistence layer.
	 * @param id a unique lookup
	 * @return a grocery with a matching ID
	 */
	GroceryDTO fetchById(int id);

	/**
	 * Persist the given DTO
	 * @param groceryDTO
	 * @return 
	 *
	 */
	GroceryDTO save(GroceryDTO groceryDTO);
	
	/**
	 * Return all grocery products
	 * @return the collection of products
	 */
	List<GroceryDTO> fetchAll();

}