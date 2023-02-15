package com.thebookStore.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


/***********************************************************************************
 *         @author           Addi Srujana
 *         Description       It is an entity class for Payment with constructors, getters and setters
 *         Version           1.0
 *         Created Date      09-FEB-2023
 ************************************************************************************/
@Entity
@Table(name = "payment")
public class Payment {
	
	@Id
	@GeneratedValue
	private Integer paymentId;
	
	
	private PaymentStatus status;
	
	public enum PaymentStatus{
		PENDING,PAID
	}
	
	public Payment() {
		super();
	}
	public Payment(Integer paymentId,PaymentStatus status) {
		super();
		
		this.paymentId = paymentId;
		this.status = status;
	}

	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public PaymentStatus getStatus() {
		return status;
	}
	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
	
	

}
