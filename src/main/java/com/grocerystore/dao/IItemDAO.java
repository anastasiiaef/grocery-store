package com.grocerystore.dao;

import java.util.List;

import com.grocerystore.dto.ItemDTO;

public interface IItemDAO {

	List<ItemDTO> fetch(String searchFilter) throws Exception;

}