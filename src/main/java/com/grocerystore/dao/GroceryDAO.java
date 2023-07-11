package com.grocerystore.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grocerystore.dto.GroceryDTO;

@Component 
public class GroceryDAO implements IGroceryDAO {

	@Autowired
	GroceryRepository groceryRepository;
	@Override
	public boolean save(GroceryDTO groceryDTO) throws Exception {
		// TODO Auto-generated method stub
		groceryRepository.save(groceryDTO);
		return false;
	}

}
