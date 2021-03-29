package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Department;
import com.cognizant.springlearn.service.departmentservice.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/departments")
	public ArrayList<Department> getAllDepartments()
	{
		return deptService.getAllDepartments();
	}
}
