package service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import repository.StudentRepository;
import service.model.Response;
import service.model.StudentListResponse;

@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentRepository repository;

	public Response getAllStudents() {
		StudentListResponse response = new StudentListResponse();
		response.setStudents(repository.findAll());
		return response;
	}
}
