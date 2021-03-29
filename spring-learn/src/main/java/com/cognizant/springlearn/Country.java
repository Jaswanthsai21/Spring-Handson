package com.cognizant.springlearn;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Country {
	
	private static final Logger LOGGER = LogManager.getLogger(Country.class);
	@NotNull
	@Size(min=2, max=2, message="Country code should be 2 characters")
	private String code;
	private String name;
	
	public Country()
	{
		LOGGER.debug("Inside Country Constructor");
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
	
}
