package com.sumit.shingari.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.shingari.data.model.Student;
import com.sumit.shingari.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

	private final StudentRepository repository;
	
	@GetMapping("")
	public Iterable<Student> getAllStudents() {
		Iterable<Student> students = repository.findAll();
		return students;
	}
	
	@PostMapping("")
	public void saveStudent(Student student) {
		repository.save(student);
	}
	
	
}
