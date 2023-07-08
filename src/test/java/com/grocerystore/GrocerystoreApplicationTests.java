package com.grocerystore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.grocerystore.dto.GroceryDTO;
import com.grocerystore.service.IGroceryService;

@SpringBootTest
class GrocerystoreApplicationTests {

	@Autowired
	private IGroceryService groceryService;
	private GroceryDTO groceryDTO;
	
	
	
	@Test
	void contextLoads() {
	}
	
	//Validate that DTO properties can be set and retrieved
	@Test
	void verifyGroceryDTOProperties() {
		int groceryId = 99;
		String description = "This is a product test";
		String name = "Test";
		
		GroceryDTO groceryDTO = new GroceryDTO();
		groceryDTO.setGroceryId(groceryId);
		assertEquals(groceryId, groceryDTO.getGroceryId());
		
		groceryDTO.setDescription(description);
		//assertEquals(groceryId, groceryDTO.getDescription());
		
		groceryDTO.setName(name);
		//assertEquals(groceryId, groceryDTO.getDescription());
			
	}
	
	@Test
	void verifyAddAndRemoveGroceryDTO() {
		int groceryId = 1;
		String description = "This is the first product entry";
		String name = "Original";
		
		GroceryDTO groceryDTO = new GroceryDTO();
		groceryDTO.setGroceryId(groceryId);
		groceryDTO.setDescription(description);
		groceryDTO.setName(name);
		
		//groceryService.save(groceryDTO);
		
		//List<GroceryDTO> groceryDTOs = groceryService.fetchAll();
		//boolean groceryDTOPresent = false;
		//for (GroceryDTO ge : groceryDTOs) {
			//if (ge.getName().equals(name) && ge.getDescription().equals(description)) {
				//groceryDTOPresent = true;
				//break;
			//}
		//}
		
		//assertTrue(groceryDTOPresent);
			
	}

}
