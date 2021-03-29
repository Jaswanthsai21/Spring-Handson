package com.cognizant.springlearn.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.service.countryservice.CountryServiceImpl;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {
	
	private static final Logger LOGGER = LogManager.getLogger(CountryController.class);
	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	
	@Autowired
	private Country country;
	
	@Autowired
	private CountryServiceImpl service;
	
	//SPRING-REST-HOL-002 --> Handson -2
	@RequestMapping(value="/country",method=RequestMethod.GET)
	public Country getCountry()
	{
		LOGGER.info("SPRING-REST-HOL-002 --> Handson -2");
		return country;
	}
	//SPRING-REST-HOL-002 --> Handson -3
	@RequestMapping(value="/countries",method=RequestMethod.GET)
	public List<Country> getAllCountries()
	{
		LOGGER.info("SPRING-REST-HOL-002 --> Handson -3");
		List<Country> countries = (List<Country>) context.getBean("countryList");
		return countries;
	}
	
	//SPRING-REST-HOL-002 --> Handson -4 
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException
	{
		LOGGER.info("SPRING-REST-HOL-002 --> Handson -4");
		return service.getCountry(code);
	}
	
	@PostMapping("/countries")
	public void addCountry(@RequestBody @Valid Country country) {
		LOGGER.info("START");
		/*ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		Validator validator = factory.getValidator();

		// Validation is done against the annotations defined in country bean

		Set<ConstraintViolation<Country>> violations = validator.validate(country);

		List<String> errors = new ArrayList<String>();

		// Accumulate all errors in an ArrayList of type String

		for (ConstraintViolation<Country> violation : violations) {

		errors.add(violation.getMessage());

		}

		// Throw exception so that the user of this web service receives appropriate error message

		if (violations.size() > 0) {

		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());

		}*/
		LOGGER.debug("Added {}", country);
		LOGGER.info("END");
	
	}
}
