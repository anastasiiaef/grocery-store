package com.grocerystore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grocerystore.dao.IGroceryDAO;
import com.grocerystore.dao.IItemDAO;
import com.grocerystore.dto.GroceryDTO;
import com.grocerystore.dto.ItemDTO;

@Component
public class GroceryService implements IGroceryService {
	
	@Autowired
	IItemDAO itemDAO;

	@Autowired 
	IGroceryDAO groceryDAO;
	@Override
	public GroceryDTO fetchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(GroceryDTO groceryDTO) throws Exception {
		// TODO Auto-generated method stub
		groceryDAO.save(groceryDTO);
		return false;
	}

	@Override
	public List<ItemDTO> fetchItems(String searchTerm) throws Exception {
		return itemDAO.fetch(searchTerm);
	}

	@Override
	public void setGroceryDAO(IGroceryDAO groceryDAO) {
		// TODO Auto-generated method stub

	}

	@Override
	public IGroceryDAO getGroceryDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
