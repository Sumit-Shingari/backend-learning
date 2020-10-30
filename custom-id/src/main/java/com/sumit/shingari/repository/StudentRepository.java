package com.sumit.shingari.repository;

import org.springframework.data.repository.CrudRepository;

import com.sumit.shingari.data.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
