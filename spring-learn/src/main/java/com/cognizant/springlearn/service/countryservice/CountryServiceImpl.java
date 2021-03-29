package com.cognizant.springlearn.service.countryservice;


import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryServiceImpl implements CountryService{
	private static final Logger LOGGER = LogManager.getLogger(SpringLearnApplication.class);
	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	ArrayList<Country> countries = (ArrayList<Country>) context.getBean("countryList");

	public Country getCountry(String code) throws CountryNotFoundException {
		Country country = countries.stream().filter(coun -> coun.getCode().equalsIgnoreCase(code)).findAny().orElse(null);
		if (country == null) {
			throw new CountryNotFoundException();
		}
		return country;
	}
	
}
