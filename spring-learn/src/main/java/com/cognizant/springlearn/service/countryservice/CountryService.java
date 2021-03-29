package com.cognizant.springlearn.service.countryservice;

import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public interface CountryService {

	public Country getCountry(String code) throws CountryNotFoundException;
}
