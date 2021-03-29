package com.cognizant.springlearn;

import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@ImportResource({ "classpath:country.xml" })
public class SpringLearnApplication {
	private static final Logger LOGGER = LogManager.getLogger(SpringLearnApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayCountry();
		displayCountries();
		
	}
	//SPRING-REST-HOL-001 --> Handson - 1 & 2
	public static void displayCountry()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.info("Country");
		LOGGER.debug("Country : {}", country.toString());
		LOGGER.debug("Instance of a country : "+country.hashCode());
		LOGGER.info("Another Country");
		LOGGER.debug("Country : {}", anotherCountry.toString());
		LOGGER.debug("Instance of another country : "+anotherCountry.hashCode());
		((ClassPathXmlApplicationContext) context).close();
		
	}
	//SPRING-REST-HOL-001 --> Handson - 3
	public static void displayCountries()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countryList = context.getBean("countryList", ArrayList.class);
		LOGGER.info("START OF DISPLAY COUNTRIES");
		LOGGER.debug("Country List:"+countryList);
		LOGGER.info("END OF DISPLAY COUNTRIES");
		((ClassPathXmlApplicationContext) context).close();
	}
	
	

}
