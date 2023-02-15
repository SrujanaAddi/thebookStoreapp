package com.thebookStore.app.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thebookStore.app.entity.Payment;

import com.thebookStore.app.exception.PaymentException;
import com.thebookStore.app.repositiory.PaymentRepository;


/***********************************************************************************
 *         @author           Addi Srujana
 *         Description       It is a service class that provides the services for adding a new payment, 
 *          				 updating the payment, viewing the payment, getting all the payments,
 *          				 and deleting a payment.
 *         Version           1.0
 *         Created Date      09-FEB-2023
 ************************************************************************************/
@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepository;
	
	
	/************************************************************************************
	 * Method:-Add new payment to database
     * Description: 	      -To add a new payment to database
	 * @param Payment         -Payment to be added to database
	 * @returns Payment       -Payment is returned after adding to database
     * Created By   -Addi Srujana
     * Created Date -11-FEB-2023                          
	 
	 ************************************************************************************/
	@Override
	public Payment addPayment(Payment payment) {
		
		return paymentRepository.save(payment);
	}
	
	
	/************************************************************************************
	 * Method:-getPaymentById
     * Description: 	    				-To get a payment from database
	 * @param paymentId        				-Id of the payment to be returned
	 * @returns Payment       				-Payment is returned 
	 * @throws PaymentException  			-raised if the paymentId does not exist in database
     * Created By           -Addi Srujana
     * Created Date         -10-FEB-2023                          
	 
	 ************************************************************************************/
	@Override
	public Payment getPaymentbyId(Integer paymentId) throws PaymentException{
		Optional<Payment> optPayment = paymentRepository.findById(paymentId);
		if(optPayment.isEmpty()) {
			throw new PaymentException("Payment id not found: " +paymentId);
		}
		
		return optPayment.get();
		
	}
	

	/************************************************************************************
	 * Method:-getAllPayments
     * Description: 	    				    -To get list of payments from database
	 * @returns List<Payment>       			-List of all the books present in the database is returned
     * Created By          					    -Addi Srujana
     * Created Date         					-10-FEB-2023                          
	 
	 ************************************************************************************/
	@Override
	public List<Payment> getallPayments() {
		
		return paymentRepository.findAll();
	}
	

	/************************************************************************************
	 * Method:-updatePayment
     * Description: 	    				-To update a payment in database
	 * @param paymentId        				-Id of the payment to be updated
	 * @returns Payment      				-Payment is returned after updating to database
	 * @throws PaymentException  			-raised if the paymentId does not exist in database
     * Created By          				 	-Addi Srujana
     * Created Date         				-10-FEB-2023                          
	 
	 ************************************************************************************/
	@Override
	public Payment updatePayment(Payment payment) throws PaymentException{
		Optional<Payment> optPayment = paymentRepository.findById(payment.getPaymentId());
		if(optPayment.isEmpty()) {
			throw new PaymentException("Payment id not found: " +payment.getPaymentId());
		}
		
		
		return paymentRepository.save(payment);
	}
	
	/************************************************************************************
	 * Method:-removePaymentById
     * Description: 	    				-To remove a payment from database
	 * @param paymentId       				-Id of the payment to be removed
	 * @returns Payment     				-Payment is returned after adding to database
	 * @throws PaymentException  			-raised if the paymentId does not exist in database
     * Created By           				-Addi Srujana
     * Created Date         				-10-FEB-2023                          
	 
	 ************************************************************************************/
	@Override
	public Payment deletePaymentById(Integer paymentId) throws PaymentException {
		Optional<Payment> optPayment = paymentRepository.findById(paymentId);
		if(optPayment.isEmpty()) {
			throw new PaymentException("Payment id not found: " +paymentId);
		}
		Payment delPayment = optPayment.get();
		this.paymentRepository.delete(delPayment);
		return delPayment;
	}

}
