package com.example.kotesh.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kotesh.model.Employee;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index(){
		return "Hello Test Rest Controller";
	}
	
   	@RequestMapping(value = "/getEmp/{empNo}", method = RequestMethod.GET, produces = "application/json")
	public Employee getMethod(@PathVariable String empNo){
		System.out.println("Employee Id"+empNo);
		Employee e= new Employee();
		e.setFirstName("koteswr");
		return e;
	}
   	
	@RequestMapping(value = "/getEmps/{empNo}/{empName}", method = RequestMethod.GET, produces = "application/json")
	public Employee getMethod(@PathVariable("empNo") String empNo, @PathVariable("empName") String empName){
		System.out.println("Employee Id"+empNo);
		System.out.println("Employee Name"+empName);
		Employee e= new Employee();
		e.setFirstName("koteswr");
		return e;
	}

	@RequestMapping(name="/postEmp", method = RequestMethod.POST)
	//@RequestMapping(name = "/getEmp", method = RequestMethod.GET,produces = { "application/json", "application/xml" })
	public void postDemo(@RequestBody Employee e){
		System.out.println("Employee Demo"+e);
	}

}
