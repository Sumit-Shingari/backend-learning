package service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import data.model.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentListResponse extends Response {

	@JsonIgnoreProperties("teachers")
	private Iterable<Student> students;
}
