package com.thebookStore.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thebookStore.app.entity.Orders;
import com.thebookStore.app.exception.OrdersException;
import com.thebookStore.app.service.OrdersService;

@RestController
public class OrdersController {
	
	@Autowired
	private OrdersService orderService;
	
	@PostMapping("/order")
	public Orders registerOrder(@RequestBody Orders order) {
		
		return orderService.addOrder(order);
	}
	
	@GetMapping("/order/{id}")
	public Orders getOrderById(@PathVariable("id") Integer orderId) throws OrdersException {
		
		return orderService.getOrderById(orderId);
	}
	
	@DeleteMapping("/order/{id}")
	public Orders deleteOrderById(@PathVariable("id") Integer orderId) throws OrdersException  {
		
		return this.orderService.deleteOrderById(orderId);
	
	}
	
	@GetMapping("/orders")
	public List<Orders> getAllOrders(){
		
		return orderService.getAllOrders();
	}
	
	@PutMapping("/order")
    public Orders updateOrder(@RequestBody Orders order) {
		
		return orderService.updateOrder(order);
	}
	
	
	
}
