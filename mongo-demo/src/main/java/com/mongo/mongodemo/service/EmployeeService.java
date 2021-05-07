package com.mongo.mongodemo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mongo.mongodemo.model.Employee;
import com.mongo.mongodemo.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository repository;
	
	public List<Employee> getAllEmployee() {
		return repository.findAll();
	}

	public Map<String, Object> getAllEmployeePagination(String pageNo, String pageSize, String sortBy) {
		Map<String, Object> response = new HashMap<>();
		Sort sort = Sort.by(sortBy);
		Pageable page = PageRequest.of(Integer.valueOf(pageNo), Integer.valueOf(pageSize), sort);
		Page<Employee> findAll = repository.findAll(page);
		response.put("data", findAll.getContent());
		response.put("total no of elements", findAll.getTotalElements());
		response.put("total no of pages", findAll.getTotalPages());
		response.put("current page no", findAll.getNumber());
		return response;
	}

	public List<Employee> getEmployeeByExample(Employee emp) {
//		ExampleMatcher matcher = ExampleMatcher.matchingAny().withIgnoreCase().withMatcher("firstName", GenericPropertyMatcher.of(StringMatcher.ENDING));
		Example<Employee> example = Example.of(emp);
		return repository.findAll(example);
	}

	public List<Employee> getEmployeeByFirstname(String firstName) {
		// TODO Auto-generated method stub
		return repository.findByFirstNameStartingWith(firstName);
	}

	public List<Employee> getEmployeeByZipcode(int zipcode) {
		// TODO Auto-generated method stub
		return repository.findByAddressZipcode(zipcode);
	}

	public List<Employee> getEmployeeBySalary(float salary) {
		// TODO Auto-generated method stub
		return repository.findBySalary(salary);
	}
}
