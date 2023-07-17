package com.grocerystore.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.grocerystore.dao.IGroceryDAO;
import com.grocerystore.dto.GroceryDTO;
import com.grocerystore.dto.ItemDTO;
import com.grocerystore.dto.PhotoDTO;


public class GroceryServiceStub implements IGroceryService {
	
	private IGroceryDAO groceryDAO;
	
	@Override
	public IGroceryDAO getGroceryDAO() {
		return groceryDAO;
	}

	@Override
	public void setGroceryDAO(IGroceryDAO groceryDAO) {
		this.groceryDAO = groceryDAO;
	}

	@Override
	public GroceryDTO fetchById(int id) {
		GroceryDTO groceryDTO = new GroceryDTO();
		groceryDTO.setGroceryId(9);
		groceryDTO.setName("Banana");
		groceryDTO.setDescription("Fruit");
		return groceryDTO;
	}

	 @Override
	public boolean save(GroceryDTO groceryDTO) throws Exception {
		 boolean result = groceryDAO.save(groceryDTO);
		 return result;
		
	} 

	@Override
	public List<ItemDTO> fetchItems(String searchTerm){
		//stub out a item fetch mechanism
		List<ItemDTO> matchingItems = new ArrayList<ItemDTO>();
		
		if (searchTerm.contains("ilk") || searchTerm.contains("ruth")) {
			ItemDTO item = new ItemDTO();
			item.setBrand("Simple Truth");
			item.setPrice(6);
			matchingItems.add(item);
		}
		return matchingItems;
	}

	@Override
	public Iterable<GroceryDTO> fetchAllGrocery() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void saveImage(MultipartFile imageFile, PhotoDTO photoDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
