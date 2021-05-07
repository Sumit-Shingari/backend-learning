package com.mongo.mongodemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongo.mongodemo.model.Address;
import com.mongo.mongodemo.model.Employee;
import com.mongo.mongodemo.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class MongoDemoApplication implements CommandLineRunner {

	private final EmployeeRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(MongoDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Employee> employees = new ArrayList<>();
		
		Employee emp1 = new Employee("Sumit", "Shingari", new Address("line 1", "line 2", "Kanpur", "up", 1234), (float) 50000);
		Employee emp2 = new Employee("Amit", "Singh", new Address("line 1", "line 2", "Kanpur", "up", 1234), (float) 110000);
		
		employees.add(emp1);
		employees.add(emp2);
		
		repository.insert(employees);
		
	}

}
