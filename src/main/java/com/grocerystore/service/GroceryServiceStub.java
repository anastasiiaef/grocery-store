package com.grocerystore.service;

import org.springframework.stereotype.Component;

import com.grocerystore.dto.GroceryDTO;

@Component
public class GroceryServiceStub implements IGroceryService {
	
	@Override
	public GroceryDTO fetchById(int id) {
		GroceryDTO groceryDTO = new GroceryDTO();
		groceryDTO.setGroceryId(9);
		groceryDTO.setName("Banana");
		groceryDTO.setDescription("Fruit");
		return groceryDTO;
	}

	@Override
	public void save(GroceryDTO groceryDTO) {
		
	}
}
