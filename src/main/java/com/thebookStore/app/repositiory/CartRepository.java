package com.thebookStore.app.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thebookStore.app.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
