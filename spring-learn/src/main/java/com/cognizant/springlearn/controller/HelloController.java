package com.cognizant.springlearn.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.SpringLearnApplication;

@RestController
public class HelloController {
	private static final Logger LOGGER = LogManager.getLogger(SpringLearnApplication.class);
	//SPRING-REST-HOL-002 --> Handson -1
	@GetMapping("/hello")
	public String sayHello()
	{
		return "Hello World!!";
	}

}
