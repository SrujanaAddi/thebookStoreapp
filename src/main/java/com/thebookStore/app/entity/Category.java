package com.thebookStore.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/***********************************************************************************
 *         @author           Addi Srujana
 *         Description       It is an entity class for Cateogry with constructors, getters and setters
 *         Version           1.0
 *         Created Date      09-FEB-2023
 ************************************************************************************/
@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue
	private Integer categoryId;
	@NotNull(message = "Name of cateogry required")
	private String categoryName;
	
	@OneToMany
	private List<Books> newBooks = new ArrayList<>();

	public Category() {
		super();
	}

	public Category(Integer categoryId, String categoryName, List<Books> newBooks) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.newBooks = newBooks;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Books> getNewBooks() {
		return newBooks;
	}

	public void setNewBooks(List<Books> newBooks) {
		this.newBooks = newBooks;
	}
	

}
