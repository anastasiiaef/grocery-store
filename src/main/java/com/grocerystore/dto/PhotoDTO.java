package com.grocerystore.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="photos")
public class PhotoDTO {

	@Id
	@GeneratedValue
	private int photoId;
	private String photographer;
	private String path;
	private String fileName;
	private String comments;
	
	@ManyToOne
	@JoinColumn(name="GROCERY_ID")
	private GroceryDTO groceryDTO;
	
	public GroceryDTO getGroceryDTO() {
		return groceryDTO;
	}
	public void setGroceryDTO(GroceryDTO groceryDTO) {
		this.groceryDTO = groceryDTO;
	}
	public String getPhotographer() {
		return photographer;
	}
	public void setPhotographer(String photographer) {
		this.photographer = photographer;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
