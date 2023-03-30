package com.gcu.business;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger logger = LoggerFactory.getLogger(OrdersBusinessService.class);

	@Override
	public void test() {
		System.out.println("Inside OrdersBusinessService.");
	}

	@Override
	public void init() {
		logger.info("Initializing OrdersBusinessService");
	}

	@Override
	public void destroy() {
		logger.info("Destroying OrdersBusinessService");
	}

	@Override
	public List<OrderModel> getOrders()
	{
		logger.info("ENTERING: getOrders() inside OrdersBusinessService");
		logger.info("COLLECTING DATA FROM DATABASE...");
		
		List<OrderEntity> ordersEntity = service.findAll();
		
		List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
		for(OrderEntity entity : ordersEntity)
		{
			ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
		}
		
		if (ordersDomain.isEmpty())
		{
			logger.error("NO DATA FOUND: Is the database connected?");
		} else {
			logger.info("DATA COLLECTED FROM DATA SERVICE. RETURNING.");
		}	
		logger.info("EXITING: getOrders() inside OrdersBusinessService");
		return ordersDomain;
		
	}


}
