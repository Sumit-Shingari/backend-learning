package service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import repository.TeacherRepository;
import service.model.Response;
import service.model.TeacherListResponse;

@Service
@RequiredArgsConstructor
public class TeacherService {

	private final TeacherRepository repository;

	public Response getAllTeachers() {
		TeacherListResponse response = new TeacherListResponse();
		response.setTeachers(repository.findAll());
		return response;
	}
}
