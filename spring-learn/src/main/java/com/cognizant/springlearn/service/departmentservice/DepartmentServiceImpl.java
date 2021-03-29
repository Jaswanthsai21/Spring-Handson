package com.cognizant.springlearn.service.departmentservice;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Department;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.dao.departmentDao.DepartmentDao;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	private static final Logger LOGGER = LogManager.getLogger(SpringLearnApplication.class);
	@Autowired 
	private DepartmentDao departmentDao;
	
	@Override
	public ArrayList<Department> getAllDepartments()
	{
		LOGGER.info("Department Service");
		return departmentDao.getAllDepartments();
	}
}
