package com.grocerystore.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="grocery", schema = "PUBLIC")
public class GroceryDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="GROCERY_ID")
	private int groceryId;
	@Column(name="ITEM_ID")
	private int itemId;
	@Column(name="NAME")
	private String name;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="ITEM_NAME")
	private String itemName;
	
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
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
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
