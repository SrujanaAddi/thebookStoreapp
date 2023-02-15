package com.thebookStore.app.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;


/***********************************************************************************
 *         @author           Addi Srujana
 *         Description       It is an entity class for Orders with constructors, getters and setters
 *         Version           1.0
 *         Created Date      09-FEB-2023
 ************************************************************************************/
@Entity
@Table(name = "orders")
public class Orders {

	@Id
	private Integer orderId;
	private Integer Quantity;
	@FutureOrPresent
	private LocalDate orderDate;
	@Min(value = 0, message = "Cost should not be negative")
	private Float totalCost;
	private String OrderStatus;
	
	@OneToOne
	private Payment payment;
	
	@OneToMany
	private List<Books> books = new ArrayList<>();
	

	public Orders() {
		super();
	}


	public Orders(Integer orderId, Integer quantity, LocalDate orderDate, Float totalCost, String orderStatus,
			Payment payment, List<Books> books) {
		super();
		this.orderId = orderId;
		Quantity = quantity;
		this.orderDate = orderDate;
		this.totalCost = totalCost;
		OrderStatus = orderStatus;
		this.payment = payment;
		this.books = books;
	}


	public Integer getOrderId() {
		return orderId;
	}


	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


	public Integer getQuantity() {
		return Quantity;
	}


	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}


	public LocalDate getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}


	public Float getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}


	public String getOrderStatus() {
		return OrderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}


	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}


	public List<Books> getBooks() {
		return books;
	}


	public void setBooks(List<Books> books) {
		this.books = books;
	}
	
	
}
