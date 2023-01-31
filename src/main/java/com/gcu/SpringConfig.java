package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.business.AnotherOrdersBusinessService;
import com.gcu.business.OrdersBusinessService;
import com.gcu.business.OrdersBusinessServiceInterface;

// The Spring framework enables automatic dependency injection.
// In other words, by declaring all the bean dependencies in 
// a Spring configuration file, Spring container can autowire
// relationships between collaborating beans.
@SuppressWarnings("unused")
@Configuration
public class SpringConfig {
	
	@Bean(name="ordersBusinessService", initMethod="init", destroyMethod="destroy")
	//@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
	//@RequestScope
	//@SessionScope
	public OrdersBusinessServiceInterface getOrdersBusiness()
	{
		// Return defines which java class is invoked
		// that implements the OrdersBusinessServiceInterface
		return new OrdersBusinessService();
	}
}
