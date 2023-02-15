package com.thebookStore.app.service;

import java.util.List;

import com.thebookStore.app.entity.Orders;
import com.thebookStore.app.exception.OrdersException;

public interface OrdersService {
	public Orders addOrder(Orders newOrder);

	public Orders updateOrder(Orders updateOrder);

	public Orders deleteOrderById(Integer orderId) throws OrdersException;

	public Orders getOrderById(Integer orderId) throws OrdersException;

	public List<Orders> getAllOrders();
	

}
