package com.gcu.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	// Dependency Injection 
	// We can use autowiring on properties, setters, and constructors.
	// Using autowired on a property eliminates the need for getters and setters.
	// When autowiring a property in bean, the property's class type is used
	// for searching a matching bean definition in the configuration file. 
	// If a bean is found, it is injected into the property
	// In this case autowiring to SpringConfig getOrdersBusiness Method.
	@Autowired
	private OrdersBusinessServiceInterface service;
	
	@Autowired
	private SecurityBusinessService security;
	
	@GetMapping("/")
	public String display(Model model)
	{
		// Display the login form view
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
	{
		//Check for validation errors
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		//Calling the test method in OrdersBusinessService
		service.test();
		
		//Calling authenticate in SecurityBusinessService
		security.authenticate("Username", "Password");
		
		//Navigate to the orders view
		model.addAttribute("title", "My Orders");
		model.addAttribute("orders", service.getOrders());	
		return "orders";
	}
	
}
