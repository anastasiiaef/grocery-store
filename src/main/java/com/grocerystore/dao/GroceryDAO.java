package com.grocerystore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grocerystore.dto.GroceryDTO;

import retrofit2.Retrofit;

@Component 
public class GroceryDAO implements IGroceryDAO {
	
	@Autowired
	GroceryRepository groceryRepository;
	
	@Override
	public boolean save(GroceryDTO groceryDTO) throws Exception {
		groceryRepository.save(groceryDTO);
		return false;
	}
	//change
	@Override
	public Iterable<GroceryDTO> fetchAll() throws Exception {
		return groceryRepository.findAll();
	}
	/*
	//this is a change 
	@Override
	public List<GroceryDTO> fetch(String searchFilter) throws Exception {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://grocerystore.com")
				.addConverterFactory(GsonConverterFactor.create())
				.build();
	}
	//end change
	*/
	//this is the original
	@Override
	public List<GroceryDTO> fetchGroceryByItemId(int itemID) {
		return groceryRepository.findByItemId(itemID);
	}
}
