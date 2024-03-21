package com.springbeginnerproject.mypkg.service;

import java.util.List;

import com.springbeginnerproject.mypkg.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentById(Long departmentId);

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartmentById(Long departmentId, Department department );

	public Department fetchDepartmentByName(String departmentName);
	
}
