package com.cognizant.springlearn.service.departmentservice;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Department;

@Service
public interface DepartmentService {

	public ArrayList<Department> getAllDepartments();
}
