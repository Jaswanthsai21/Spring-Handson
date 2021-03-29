package com.cognizant.springlearn.service.employeeservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.dao.employeeDao.EmployeeDao;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Service
public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException;
	public void deleteEmployee(int id) throws EmployeeNotFoundException;
}
