package com.grocerystore.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.grocerystore.dao.IGroceryDAO;
import com.grocerystore.dto.GroceryDTO;
import com.grocerystore.dto.ItemDTO;
import com.grocerystore.dto.PhotoDTO;

/**
 * CRUD operations for grocery.
 * @author anastasiiaefimova
 *
 */
public interface IGroceryService {

	/**
	 * Get grocery from persistence layer.
	 * @param id a unique lookup
	 * @return a grocery with a matching ID
	 */
	GroceryDTO fetchById(int id);

	/**
	 * Persist the given DTO
	 * @param groceryDTO
	 * @return 
	 *
	 */
	boolean save(GroceryDTO groceryDTO) throws Exception;
	
	/**
	 * Return a list of items that containg strig.
	 * @param string the search criteria.
	 * @return a list of matching items
	 */
	List<ItemDTO> fetchItems(String string) throws Exception;

	void setGroceryDAO(IGroceryDAO groceryDAO);

	IGroceryDAO getGroceryDAO();

	Iterable<GroceryDTO> fetchAllGrocery() throws Exception;

	void saveImage(MultipartFile imageFile, PhotoDTO photoDTO) throws Exception;

}