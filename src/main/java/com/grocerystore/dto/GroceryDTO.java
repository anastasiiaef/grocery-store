package com.grocerystore.dto;

public class GroceryDTO {
	
	private int groceryId;
	private String description;
	private String name;
	private int itemId;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getGroceryId() {
		return groceryId;
	}
	public void setGroceryId(int groceryId) {
		this.groceryId = groceryId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return groceryId + " " + name + " "+ description;
	}

	@Override
	public boolean equals(Object obj) {
		boolean returnValue = false;
		if (obj instanceof GroceryDTO) {
			GroceryDTO incomingGrocery = (GroceryDTO) obj;
			returnValue = incomingGrocery.getGroceryId() == getGroceryId();
		}
		return returnValue;
	}
}
