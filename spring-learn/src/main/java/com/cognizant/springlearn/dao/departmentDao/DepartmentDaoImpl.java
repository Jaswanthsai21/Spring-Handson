package com.cognizant.springlearn.dao.departmentDao;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.Department;
import com.cognizant.springlearn.SpringLearnApplication;

@Component
public class DepartmentDaoImpl implements DepartmentDao{
	private static final Logger LOGGER = LogManager.getLogger(SpringLearnApplication.class);
	public static ArrayList<Department> DEPARTMENT_LIST = new ArrayList<>();
	
	
	public DepartmentDaoImpl() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		DEPARTMENT_LIST = (ArrayList<Department>) context.getBean("departmentList");
	}

	
	@Override
	public ArrayList<Department> getAllDepartments()
	{
		
		return DEPARTMENT_LIST;
	}
}
