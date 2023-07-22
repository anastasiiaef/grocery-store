package com.grocerystore.dao;

import java.util.List;

import com.grocerystore.dto.GroceryDTO;

public interface IGroceryDAO {
	
	boolean save(GroceryDTO groceryDTO) throws Exception;

	Iterable<GroceryDTO> fetchAll() throws Exception;

	List<GroceryDTO> fetchGroceryByItemId(int itemId);
//this is a change
	//List<GroceryDTO> fetch(String searchFilter) throws Exception;

}
