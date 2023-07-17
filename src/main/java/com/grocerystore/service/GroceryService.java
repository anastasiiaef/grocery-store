package com.grocerystore.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.grocerystore.dao.IGroceryDAO;
import com.grocerystore.dao.IItemDAO;
import com.grocerystore.dao.IPhotoDAO;
import com.grocerystore.dto.GroceryDTO;
import com.grocerystore.dto.ItemDTO;
import com.grocerystore.dto.PhotoDTO;



@Component
public class GroceryService implements IGroceryService {
	
	@Autowired
	IItemDAO itemDAO;

	@Autowired 
	IGroceryDAO groceryDAO;
	
	@Autowired 
	IPhotoDAO photoDAO;
	
	@Override
	public GroceryDTO fetchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(GroceryDTO groceryDTO) throws Exception {
		groceryDAO.save(groceryDTO);
		return false;
	}

	@Override
	@Cacheable("fetchItem")
	public List<ItemDTO> fetchItems(String searchTerm) throws Exception {
		return itemDAO.fetch(searchTerm);
	}
	
	@Override
	public Iterable<GroceryDTO> fetchAllGrocery() throws Exception {
		return groceryDAO.fetchAll();
	}

	@Override
	public void setGroceryDAO(IGroceryDAO groceryDAO) {
	}

	@Override
	public IGroceryDAO getGroceryDAO() {
		return null;
	}
	
	
	@Override
	public void saveImage(MultipartFile imageFile, PhotoDTO photoDTO) throws Exception {

		photoDAO.save(photoDTO);;
		photoDAO.savePhotoImage(imageFile);
	}



}
