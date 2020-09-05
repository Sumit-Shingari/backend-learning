package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import service.TeacherService;
import service.model.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping("teachers")
public class TeacherController {

	private final TeacherService service;
	
	@GetMapping
	public ResponseEntity<Response> getAllTeachers() {
		Response response = service.getAllTeachers();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
