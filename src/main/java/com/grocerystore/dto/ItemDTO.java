package com.grocerystore.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemDTO {
	@SerializedName("id")
	@Expose
	private int guid;
	@SerializedName("name")
	@Expose
	private String brand;
	@SerializedName("description")
	@Expose
	private String size;
	@SerializedName("calories")
	@Expose
	private double price;
	
	public int getGuid() {
		return guid;
	}
	public void setGuid(int guid) {
		this.guid = guid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return brand + " " + size + " " + price + "$" + " 1lb";
	}

}
