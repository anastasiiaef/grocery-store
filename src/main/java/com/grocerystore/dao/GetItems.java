package com.grocerystore.dao;

import com.grocerystore.dto.ItemList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetItems {
	
	@GET("/anastasiiaef/Data/food/")
	Call<ItemList> getAllItems(@Query("Combined_Name") String combinedName);

}
