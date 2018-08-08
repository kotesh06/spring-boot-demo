package com.example.kotesh.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kotesh.model.Employee;

@RestController
public class EmployeeController {
	
	@RequestMapping("/employee")
	public String getIndex() {
		return "Employee Rest end point";
	}
	
	@RequestMapping("/employee/{empno}")
	public Employee getEmployeeDetails(@PathVariable("empno") Long empNo) {
		Employee emp=null;
		if(empNo>100) {
			emp = new Employee();
			emp.setFirstName("Kotesh");
		}
		return emp;
	}
}
