 package com.springbeginnerproject.mypkg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbeginnerproject.mypkg.entity.Department;
import com.springbeginnerproject.mypkg.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController { 
	
	@Autowired
	private DepartmentService departmentservice;
	
	final static Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		logger.info("Inside of saveDepartment");
		return departmentservice.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList(){
		logger.info("Inside of fetchDepartmentList");
		return departmentservice.fetchDepartmentList();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId){
		return departmentservice.fetchDepartmentById(departmentId);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId){
		departmentservice.deleteDepartmentById(departmentId);
		return "Department deleted successfully";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department) {
		return departmentservice.updateDepartmentById(departmentId,department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
		return departmentservice.fetchDepartmentByName(departmentName);
	}
	
}
