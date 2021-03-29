package com.cognizant.springlearn.service.employeeservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.dao.employeeDao.EmployeeDao;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Service
public class EmplyeeServiceImpl implements EmployeeService{
	private static final Logger LOGGER = LogManager.getLogger(EmployeeService.class);
	@Autowired
	private EmployeeDao employeeDao;
	

	public List<Employee> getAllEmployees()
	{
		LOGGER.info("Employee Service");
		ArrayList<Employee> employeeList = employeeDao.getAllEmployees();
		return employeeList;
	}
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {
		return employeeDao.updateEmployee(employee);
	}
	
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		employeeDao.deleteEmployee(id);
	}
}
