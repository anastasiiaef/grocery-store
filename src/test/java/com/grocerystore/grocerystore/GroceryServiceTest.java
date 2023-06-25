package com.grocerystore.grocerystore;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.grocerystore.dto.itemsDTO;
import com.grocerystore.service.IGroceryService;

public class GroceryServiceTest {

	IGroceryService groceryService;
	 List <itemsDTO> groceries;
	 
	@Test
	public void fetchGroceries_NoResultsForUnknownData() {
		givenUserIsSignedInGroceryStore();
		whenTheUserSearchesForJunk();
		thenGroceryStoreReturnsZeroResults();
		
	}
	private void givenUserIsSignedInGroceryStore() {
		// TODO Auto-generated method stub
		
	}
	private void whenTheUserSearchesForUnknown() {
	  groceries =groceryService.fetchGroceries("fnbfjngi;dvndkvdjivnjg;qdmie;gh");
	}
	private void thenGroceryStoreReturnsZeroResults() {
		assertEquals("Number of items returns", 0, groceries.size());
	}
}
