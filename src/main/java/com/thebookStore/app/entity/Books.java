package com.thebookStore.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/***********************************************************************************
 *         @author           Addi Srujana
 *         Description       It is an entity class for Books with constructors, getters and setters
 *         Version           1.0
 *         Created Date      09-FEB-2023
 ************************************************************************************/
@Entity
@Table(name = "books")
public class Books {
	
	
	@Id
	@GeneratedValue
	private Integer bookId;
	@NotBlank(message = "Book name is needed")
	private String bookName;
	@NotBlank(message = "Author of book is needed")
	private String bookAuthor;
	@NotBlank(message = "publisher of book is needed")
	private String publisher;
	@Min(value = 0,message = "price must be greater than 0")
	private Float price;
	
	
	public Books() {
		super();
	}
	
	public Books(Integer bookId, String bookName, String bookAuthor,String publisher,Float price) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.publisher = publisher;
		this.price = price;
		
	}

	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}

	

}
