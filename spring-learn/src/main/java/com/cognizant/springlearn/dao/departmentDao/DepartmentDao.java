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
public interface DepartmentDao {
	
	public ArrayList<Department> getAllDepartments();
}
