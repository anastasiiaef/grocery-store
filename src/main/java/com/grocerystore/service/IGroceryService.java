package com.grocerystore.service;

import java.util.List;

import com.grocerystore.dto.GroceryDTO;
import com.grocerystore.dto.itemsDTO;

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
	 *
	 */
	void save(GroceryDTO groceryDTO);

	/**
	 * Return list of items that contain this string
	 * @param string the search criteria: can be title,description or type.
	 * @return a list of matching groceries
	 */
	List<itemsDTO> fetchGroceries(String string);

}