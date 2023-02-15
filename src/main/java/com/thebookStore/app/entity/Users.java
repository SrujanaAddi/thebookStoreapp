package com.thebookStore.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/***********************************************************************************
 *         @author           Addi Srujana
 *         Description       It is an entity class for Users with constructors, getters and setters
 *         Version           1.0
 *         Created Date      09-FEB-2023
 ************************************************************************************/
@Entity
@Table(name = "Users")
public class Users {
	
	@Id
	@GeneratedValue
	private Integer userId;
	@NotNull(message = "name is needed")
	private String name;
	@NotNull(message = "email is needed")
	private String emailId;
	@NotNull(message = "password is needed")
	private String password;
	
	@OneToMany
	private List<Orders> userOrders = new ArrayList<>();
	public Users() {
		super();
	}
	
	@OneToOne
	private Cart cart;
	
	

	public Users(Integer userId, String name, String emailId, String password, List<Orders> userOrders, Cart cart) {
		super();
		this.userId = userId;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.userOrders = userOrders;
		this.cart = cart;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Orders> getUserOrders() {
		return userOrders;
	}

	public void setUserOrders(List<Orders> userOrders) {
		this.userOrders = userOrders;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	 

}
