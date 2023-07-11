package com.grocerystore.dto;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemList {

		@SerializedName("items")
		@Expose
		private List<ItemDTO> items = null;

		public List<ItemDTO> getItems() {
		return items;
		}

		public void setItems(List<ItemDTO> items) {
		this.items = items;
		}
	}

