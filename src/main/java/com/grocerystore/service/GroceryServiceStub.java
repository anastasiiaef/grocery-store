package com.grocerystore.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.grocerystore.dto.GroceryDTO;
import com.grocerystore.dto.itemsDTO;


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
	@Override
	public List<itemsDTO> fetchGroceries(String searchTerm){
		List<itemsDTO> matchingItems= new Arraylist<itemsDTO> ();
		if(searchTerm.contains("sawberry") || searchTerm.contains("fruit")) {
			itemsDTO item=new itemsDTO();
			item.setDescription("sweet fresh strawberry");
			item.setPrice(29.45);
			item.setRating(4);
		}
		return null;
	};
}
