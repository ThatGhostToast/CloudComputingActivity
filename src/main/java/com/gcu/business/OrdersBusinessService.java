package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrdersDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

// To access the interface module, the interface must be implemented
// by another class with the implements key word. 
// The body of the interface method is provided by the implement class:
// The implement keyword is used by a class to that it can follow or adhere
// to the contract provided by the interface.
public class OrdersBusinessService implements OrdersBusinessServiceInterface {
	@Autowired
	OrdersDataService service;

	@Override
	public void test() {
		System.out.println("Hello from the OrdersBusinessService.");
	}

	@Override
	public void init() {
		System.out.println("Hello from init() in OrdersBusinessService");
		
	}

	@Override
	public void destroy() {
		System.out.println("Hello from destroy() in OrdersBusinessService");
		
	}

	@Override
	public List<OrderModel> getOrders()
	{
		List<OrderEntity> ordersEntity = service.findAll();
		
		List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
		for(OrderEntity entity : ordersEntity)
		{
			ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
		}
		
		return ordersDomain;
		
	}


}
