package com.cognizant.springlearn.dao.employeeDao;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
	private static final Logger LOGGER = LogManager.getLogger(SpringLearnApplication.class);
	public static ArrayList<Employee> EMPLOYEE_LIST = new ArrayList<>();

	public EmployeeDaoImpl() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList");
	}

	public ArrayList<Employee> getAllEmployees() {
		LOGGER.info("Employee Dao");
		return EMPLOYEE_LIST;
	}

	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {
		LOGGER.info("Inside updateEmployee() method");

		for (Employee empl : EMPLOYEE_LIST) {
			if (empl.getId() == employee.getId()) {
				empl.setName(employee.getName());
				empl.setSalary(employee.getSalary());
				empl.setPermanent(employee.getPermanent());
				empl.setDepartment(employee.getDepartment());
				empl.setSkill(employee.getSkill());

				return employee;
			}
		}
		throw new EmployeeNotFoundException();
	}

	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		Employee emp = null;
		for (Employee e : EMPLOYEE_LIST) {
			if (e.getId() == id) {
				emp = e;
				EMPLOYEE_LIST.remove(emp);
				break;
			}
		}
		if (emp == null) {
			throw new EmployeeNotFoundException();
		}
	}

}
