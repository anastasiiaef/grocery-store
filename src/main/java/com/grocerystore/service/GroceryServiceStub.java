package com.grocerystore.service;

import org.springframework.stereotype.Component;

import com.grocerystore.dto.GroceryDTO;

@Component
public class GroceryServiceStub implements IGroceryService {
	
	@Override
	public GroceryDTO fetchById(int id) {
		GroceryDTO groceryDTO = new GroceryDTO();
		groceryDTO.setGroceryId(9);
		groceryDTO.setName("Strawberry");
		groceryDTO.setDescription("Soft, Ripe,Red berries");
		groceryDTO.setPrice(6.50);
		groceryDTO.setQuantity(5);
		return groceryDTO;
	}

	@Override
	public void save(GroceryDTO groceryDTO) {
		
	}
}
