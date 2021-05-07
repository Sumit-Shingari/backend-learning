package com.mongo.mongodemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
public class Employee {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private Address address;
	private Float salary;
	
	public Employee(String firstName, String lastName, Address address, Float salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.salary = salary;
	}
}
