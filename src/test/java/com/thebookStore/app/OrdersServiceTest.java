package com.thebookStore.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thebookStore.app.entity.Orders;
import com.thebookStore.app.exception.OrdersException;
import com.thebookStore.app.service.OrdersService;

@SpringBootTest
public class OrdersServiceTest {

	@Autowired
	private OrdersService ordersService;
	
	@Test
	void addOrdersTest() { 
		assertNotNull(ordersService.addOrder(new Orders(100, 10, null, 100.0f, null, null, null)));
	}
	
	@Test
	void getOrderByIdTest() throws OrdersException {
		assertNotNull(ordersService.getOrderById(100));
		
	}
	@Test
	void getOrderByIdTest2() throws OrdersException {
		assertNotNull(ordersService.getOrderById(1));
	}
	
	@Test
	void getOrderByIdTest4() throws OrdersException {
		assertNotNull(ordersService.getOrderById(2));
	}
	
	@Test
	void deleteOrderByIdExceptionTest() {
		assertThrows(OrdersException.class,()-> ordersService.deleteOrderById(2));
	}
	
	@Test
	void deleteOrderByIdExceptionTest2() {
		assertThrows(OrdersException.class,()->ordersService.deleteOrderById(4));
	}
	@Test
	void updateOrdersTest() throws OrdersException{
		assertNotNull(ordersService.updateOrder(new Orders(100, 10, null, 100.0f, null, null, null)));
	}
	@Test
	void updateOrdersTest2() throws OrdersException{
		assertNotNull(ordersService.updateOrder(new Orders(100, 10, null, 100.0f, null, null, null)));
	}
	
	@Test
	void getAllOrdersTest() {
		assertNotNull(ordersService.getAllOrders());
	}


}
