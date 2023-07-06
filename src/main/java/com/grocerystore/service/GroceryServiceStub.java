package com.grocerystore.service;

import java.util.List;
import java.util.ArrayList;


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

	/* @Override
	public void save(GroceryDTO groceryDTO) {
		
	} */
	
	List<GroceryDTO> allGroceryDTOs = new ArrayList<GroceryDTO>();
	
	@Override
	public GroceryDTO save(GroceryDTO groceryDTO) {
		allGroceryDTOs.add(groceryDTO);
		return groceryDTO;
	}
	
	@Override
	public List<GroceryDTO> fetchAll(){
		return allGroceryDTOs;
	
	



	}
}
