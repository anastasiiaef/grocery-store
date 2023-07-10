package com.grocerystore.dao;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import com.grocerystore.dto.ItemDTO;

@Component
public class ItemDAO implements IItemDAO {
	
	@Autowired
	NetworkDAO networkDAO;
	
	@Override
	public List<ItemDTO> fetch(String searchFilter) throws Exception {
		
		List<ItemDTO> allItems = new ArrayList<ItemDTO>();
		String rawJson = networkDAO.request("");
		JSONObject root = new JSONObject(rawJson);
		JSONArray items = root.getJSONArray("item");
		for(int i = 0; i < items.length(); i++) {
			//the json data
			JSONObject jsonItem = items.getJSONObject(i);
			//item object
			ItemDTO item = new ItemDTO();
			int guid = jsonItem.getInt("id");
			String brand = jsonItem.getString("brand");
			String size = jsonItem.getString("size");
			int price = jsonItem.getInt("price");		
			//populate our DTO with this information
			item.setGuid(guid);
			item.setBrand(brand);
			item.setSize(size);
			item.setPrice(price);			
			//add the populated item to our collection
			allItems.add(item);
		}
		return allItems;
	}

}
