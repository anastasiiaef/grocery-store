package com.grocerystore.dao;

import com.grocerystore.dto.GroceryDTO;

public interface IGroceryDAO {
	
	boolean save(GroceryDTO groceryDTO) throws Exception;

	Iterable<GroceryDTO> fetchAll() throws Exception;

}
