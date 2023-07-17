package com.grocerystore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grocerystore.dto.GroceryDTO;

@Component 
public class GroceryDAO implements IGroceryDAO {

	@Autowired
	GroceryRepository groceryRepository;
	
	@Override
	public boolean save(GroceryDTO groceryDTO) throws Exception {
		groceryRepository.save(groceryDTO);
		return false;
	}
	
	@Override
	public Iterable<GroceryDTO> fetchAll() throws Exception {
		return groceryRepository.findAll();
	}
	
	@Override
	public List<GroceryDTO> fetchGroceryByItemId(int itemID) {
		return groceryRepository.findByItemId(itemID);
	}
}
