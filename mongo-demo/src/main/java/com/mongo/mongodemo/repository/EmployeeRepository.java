package com.mongo.mongodemo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mongo.mongodemo.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

	List<Employee> findByAddressZipcode(int zipcode);

	List<Employee> findByFirstNameStartingWith(String firstName);

	@Query(value = "{'salary': {$gte:?0}}", fields = "{'firstName':1, 'id':0}")
	List<Employee> findBySalary(float salary);

}
