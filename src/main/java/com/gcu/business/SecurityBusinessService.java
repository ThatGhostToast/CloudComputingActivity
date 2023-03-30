package com.gcu.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SecurityBusinessService {
	Logger logger = LoggerFactory.getLogger(SecurityBusinessService.class);
	
	public boolean authenticate(String username, String password)
	{
		logger.info("ENTERING: authenticate() inside SecurityBusinessService");
		System.out.println("Hello from the SecurityBusinessService");
		logger.info("Verifying user...");
		if (username.equals("Username") && password.equals(password))
		{
			logger.info("User verified!");
			logger.info("EXITING: authenticate() inside SecurityBusinessService");
			return true;
		} else {
			logger.error("User could not be verified. Login credentials not found.");
			logger.info("EXITING: authenticate() inside SecurityBusinessService");
			return false;
		}
	}
}
