package com.thebookStore.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thebookStore.app.entity.Orders;
import com.thebookStore.app.exception.OrdersException;
import com.thebookStore.app.repositiory.OrdersRepository;


/***********************************************************************************

 * @author Obulreddy Pravalika
 * Description  It is a service class that provides the services for adding a new order, 
 * to category, updating the Orders, viewing the Orders, getting all the Orders
 * and deleting a Orders.
 * Version 1.0
 * Created Date 09-FEB-2023

 ************************************************************************************/
@Service
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	private OrdersRepository orderRepository;

	
	
	@Override
	public Orders addOrder(Orders newOrder) {
		
		return orderRepository.save(newOrder);
	
	}

	
	/************************************************************************************

	 * Method:-updateOrders

	 * Description: -To update a orders in database

	 * @param OrderId -Id of the orders to be updated

	 * @returns Orders-Orders is returned after updating to database

	 * @throws OrderssException -raised if the orderId does not exist in database

	 * Created By -Obulreddy Pravalika

	 * Created Date -10-FEB-2023 

	 

	 ************************************************************************************/
	@Override
	public Orders updateOrder(Orders updateOrder) {
		 
		return this.orderRepository.save(updateOrder);
	}
	
		

	/************************************************************************************

	 * Method:-deleteOrdersById

	 * Description: -To remove a Orders from database

	 * @param OrderId -Id of the Orders to be removed

	 * @returns Orders -orders is returned after adding to database

	 * @throws OrdersException -raised if the orderId does not exist in database

	 * Created By -Obulreddy Pravalika

	 * Created Date -10-FEB-2023 

	 

	 ************************************************************************************/	
	@Override
	public Orders deleteOrderById(Integer orderId) throws OrdersException {
		
		Optional<Orders> optOrder = this.orderRepository.findById(orderId);
		if (optOrder.isEmpty())
			throw new OrdersException("Order id does not exists to delete !");
		Orders order = optOrder.get();
        this.orderRepository.delete(order);
        return order;
	}	

	
	/************************************************************************************

	 * Method:-getOrderById

	 * Description: -To get order from database

	 * @param OrderId -Id of the order to be returned

	 * @returns Books -Book is returned 

	 * @throws OrdersException -raised if the orderId does not exist in database

	 * Created By -Obulreddy Pravalika

	 * Created Date -10-FEB-2023 

	 

	 ************************************************************************************/

	@Override
	public Orders getOrderById(Integer orderId) throws OrdersException {
		Optional<Orders> optOrder = orderRepository.findById(orderId);
		if (optOrder.isEmpty())
			throw new OrdersException("Order id not found :" +orderId);
		
		return optOrder.get();
	}
	
	
	/************************************************************************************

	 * Method:-getAllOrders

	 * Description: -To get all the orders in database

	 * @returns List<Orders> -List of all the orders present in the database is returned

	 * Created By -Obulreddy Pravalika

	 * Created Date -10-FEB-2023 

	 

	 ************************************************************************************/
    @Override
	public List<Orders> getAllOrders() {
    	
    	return orderRepository.findAll();
	}


}
