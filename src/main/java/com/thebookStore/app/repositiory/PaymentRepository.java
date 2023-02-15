package com.thebookStore.app.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thebookStore.app.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
