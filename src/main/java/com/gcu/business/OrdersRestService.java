package com.gcu.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gcu.model.OrderList;
import com.gcu.model.OrderModel;

@RestController
@RequestMapping("/service")
public class OrdersRestService {
	@Autowired
	private OrdersBusinessServiceInterface service;
	
	Logger logger = LoggerFactory.getLogger(OrdersRestService.class);
	
	@GetMapping(path="/getJson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<OrderModel> getOrdersAsJson()
	{
		logger.info("ENTERING: getOrdersAsJson() inside OrdersRestService");
		logger.info("EXITING: getOrdersAsJson() inside OrdersRestService");
		return service.getOrders();
	}
	
	@GetMapping(path="/getxml", produces= {MediaType.APPLICATION_XML_VALUE})
	public OrderList getOrdersAsXml()
	{
		logger.info("ENTERING: getOrdersAsXml() inside OrdersRestService");
		OrderList list = new OrderList();
		list.setOrders(service.getOrders());
		logger.info("EXITING: getOrdersAsXml() inside OrdersRestService");
		return list;
	}
}
