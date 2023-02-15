package com.thebookStore.app.service;

import java.util.List;

import com.thebookStore.app.entity.Payment;
import com.thebookStore.app.exception.PaymentException;

public interface PaymentService {
	
	public Payment addPayment(Payment payment);
	
	public Payment updatePayment(Payment payment)throws PaymentException;
	
	public Payment getPaymentbyId(Integer paymentId) throws PaymentException;
	
	public List<Payment> getallPayments();
	
	public Payment deletePaymentById(Integer paymentId) throws PaymentException;
	

}
