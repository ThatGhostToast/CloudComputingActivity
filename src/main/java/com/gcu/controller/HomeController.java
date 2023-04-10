package com.gcu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	public String display()
	{
		logger.info("ENTERING: Root directory of the application ('/')");
		logger.info("EXITING: Root directory of the application. Redirecting user to login");
		return "redirect:/login/";
		
	}
}
