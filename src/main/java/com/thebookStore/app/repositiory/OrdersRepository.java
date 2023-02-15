package com.thebookStore.app.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thebookStore.app.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{

}
