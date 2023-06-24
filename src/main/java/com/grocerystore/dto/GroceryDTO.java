package com.grocerystore.dto;

public class GroceryDTO {
	
	private int groceryId;
	private String description;
	private String name;
	private int quantity;
	private double price;
	
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price=price;		
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return groceryId + " " +name + " " +
	description+ " " + price + " " + quantity;
	}
	
	
}
