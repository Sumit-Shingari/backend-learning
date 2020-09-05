package controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import service.StudentService;
import service.model.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping("students")
public class StudentController {

	private final StudentService service;
	
	@GetMapping
	public ResponseEntity<Response> getAllStudents() {
		Response response = service.getAllStudents();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
