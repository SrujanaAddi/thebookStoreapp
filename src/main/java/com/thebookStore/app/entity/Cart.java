package com.thebookStore.app.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;


/***********************************************************************************
 *         @author           Addi Srujana
 *         Description       It is an entity class for Cart with constructors, getters and setters
 *         Version           1.0
 *         Created Date      09-FEB-2023
 ************************************************************************************/
@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue
	private Integer cartId;
	private Float totalCost;
	
	@ManyToMany
	private Map<Integer, Books> booksInCart = new HashMap<>();
	
	

	public Cart() {
		super();
	}
	
	public Cart(Integer cartId, Float totalCost, Map<Integer, Books> booksInCart) {
		super();
		this.cartId = cartId;
		this.totalCost = totalCost;
		this.booksInCart = booksInCart;
		
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}


	public Float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}

	public Map<Integer, Books> getBooksInCart() {
		return booksInCart;
	}

	public void setBooksInCart(Map<Integer, Books> booksInCart) {
		this.booksInCart = booksInCart;
	}

	
}
