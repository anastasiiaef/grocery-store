package com.grocerystore.dao;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import com.grocerystore.dto.ItemDTO;
import com.grocerystore.dto.ItemList;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.GsonConverterFactory;

@Component
public class ItemDAO implements IItemDAO {
	
	@Autowired
	NetworkDAO networkDAO;
	
	@Override
	public List<ItemDTO> fetch(String searchFilter) throws Exception {
		
		List<ItemDTO> allItems = new ArrayList<ItemDTO>();
		String rawJson = networkDAO.request("https://my-json-server.typicode.com/anastasiiaef/Data/food");
		JSONObject root = new JSONObject(rawJson);
		JSONArray items = root.getJSONArray("item");
		for(int i = 0; i < items.length(); i++) {
				//the json data
				JSONObject jsonItem = items.getJSONObject(i);
				//item object
				ItemDTO item = new ItemDTO();
				int guid = jsonItem.getInt("id");
				String brand = jsonItem.getString("name");
				String size = jsonItem.getString("description");
				double price = jsonItem.getDouble("calories");
				
				if(brand.equals(searchFilter)) {
				//populate our DTO with this information
				item.setGuid(guid);
				item.setBrand(brand);
				item.setSize(size);
				item.setPrice(price);
			
				//add the populated item to our collection
				allItems.add(item);
			}
		}
		return allItems;
	}
	

	public List<ItemDTO> fetchM(String searchFilter) throws Exception {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://my-json-server.typicode.com/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		GetItems getItems = retrofit.create(GetItems.class);
		
		Call<ItemList> allItems = getItems.getAllItems(searchFilter);
		Response<ItemList> execute = allItems.execute();
		ItemList itemList = execute.body();		
		
		List<ItemDTO> items = itemList.getItems();
						
		return items;		
	}	
}
