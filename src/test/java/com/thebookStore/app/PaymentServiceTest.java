package com.thebookStore.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thebookStore.app.entity.Payment;
import com.thebookStore.app.entity.Payment.PaymentStatus;
import com.thebookStore.app.exception.PaymentException;
import com.thebookStore.app.service.PaymentService;

@SpringBootTest
public class PaymentServiceTest {
	
	@Autowired
	private PaymentService paymentService;
	
	@Test
	void addPaymentTest() {
		assertNotNull(paymentService.addPayment(new Payment(0, PaymentStatus.PENDING)));
		
	}
	@Test
	void updatePaymentTest() throws PaymentException {
		assertNotNull(paymentService.updatePayment(new Payment(24, PaymentStatus.PAID)));
	}
	
	@Test
	void updatePaymentExceptionTest() {
		assertThrows(PaymentException.class, ()->paymentService.updatePayment(new Payment(200, PaymentStatus.PAID)));
	}
	
	@Test
	void getPaymentByIdTest() throws PaymentException {
		assertNotNull(paymentService.getPaymentbyId(21));
	}
	
	@Test
	void getPaymentByIdExceptionTest() {
		assertThrows(PaymentException.class, ()->paymentService.getPaymentbyId(100));
	}
	
	@Test
	void getAllPaymentsTest() {
		assertNotNull(paymentService.getallPayments());
	}
	
	@Test
	void deletePaymentByIdTest() throws PaymentException{
		assertNotNull(paymentService.deletePaymentById(21));
	}
	
	@Test
	void deletePaymentByIdExceptionTest() {
		assertThrows(PaymentException.class, ()->paymentService.deletePaymentById(1000));
	}
	
	
}
