package com.thebookStore.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thebookStore.app.entity.Payment;
import com.thebookStore.app.exception.PaymentException;
import com.thebookStore.app.service.PaymentService;

@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;

	
	@PostMapping("/addPayment")
	public Payment createPayment(@Valid @RequestBody Payment payment) {
	
		return paymentService.addPayment(payment);
	}
	
	
	
	@PutMapping("/updatePayment")
	public Payment modifyPayment(@RequestBody Payment payment ) throws PaymentException {
		return paymentService.updatePayment(payment);
	}
	
	@GetMapping("/allPayments")
	public List<Payment> getPayment() {
		return paymentService.getallPayments();
		
	}
	
	@GetMapping("/payment/{id}")
	public Payment getPaymentById(@PathVariable("id") Integer paymentId) throws PaymentException{
		return paymentService.getPaymentbyId(paymentId);
	}
	
	@DeleteMapping("/payment/{id}")
	public Payment deletePaymentById(@PathVariable("id") Integer paymentId) throws PaymentException{
		return paymentService.deletePaymentById(paymentId);
	}


}
