package com.mongo.mongodemo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.mongodemo.model.Employee;
import com.mongo.mongodemo.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService service;
	
	@GetMapping
	public List<Employee> getAllEmployee () {
		return service.getAllEmployee();
	}
	
	@GetMapping("/page")
	public Map<String, Object> getAllEmployeePagination (@RequestParam(name = "pageno", defaultValue = "0") String pageNo
			, @RequestParam(name = "pagesize", defaultValue = "1") String pageSize
			,@RequestParam(name = "sortby", defaultValue = "id") String sortBy) {
		return service.getAllEmployeePagination(pageNo, pageSize, sortBy);
	}
	
	@GetMapping("/example")
	public List<Employee> getEmployeeByExample(@RequestBody Employee emp) {
		return service.getEmployeeByExample(emp);
	}
	
	@GetMapping("/firstname")
	public List<Employee> getEmployeeByFirstname(@RequestParam(name = "firstname") String firstName) {
		return service.getEmployeeByFirstname(firstName);
	}
	
	@GetMapping("/zipcode")
	public List<Employee> getEmployeeByZipcode(@RequestParam(name = "zipcode") int zipcode) {
		return service.getEmployeeByZipcode(zipcode);
	}
	
	@GetMapping("/salary")
	public List<Employee> getEmployeeBySalary(@RequestParam(name = "salary") float salary) {
		return service.getEmployeeBySalary(salary);
	}
}
