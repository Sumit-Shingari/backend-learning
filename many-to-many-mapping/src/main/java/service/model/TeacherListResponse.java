package service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import data.model.Teacher;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherListResponse extends Response{

	@JsonIgnoreProperties("students")
	private Iterable<Teacher> teachers;
}
