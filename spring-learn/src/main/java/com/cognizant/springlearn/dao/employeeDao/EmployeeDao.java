package com.cognizant.springlearn.dao.employeeDao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.cognizant.springlearn.Employee;

import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Component
public interface EmployeeDao {
	
	public ArrayList<Employee> getAllEmployees();
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException;
	public void deleteEmployee(int id) throws EmployeeNotFoundException;
}
