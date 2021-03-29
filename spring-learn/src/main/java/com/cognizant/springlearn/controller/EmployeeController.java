package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.employeeservice.EmployeeService;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@RestController
public class EmployeeController {

	ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
	ArrayList<Employee> employees = (ArrayList<Employee>) context.getBean("employeeList");

	@Autowired
	private EmployeeService emplService;

	@GetMapping("/employees")
	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> employeeList = (ArrayList<Employee>) emplService.getAllEmployees();
		return employeeList;
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id, @RequestBody @Valid Employee employee)
			throws EmployeeNotFoundException {
		for (Employee emp : employees) {
			if (id == emp.getId()) {
				return emp;
			}
		}
		return null;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {

		return emplService.updateEmployee(employee);

	}

	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
		emplService.deleteEmployee(id);
	}

}
