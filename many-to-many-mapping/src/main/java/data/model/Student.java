package data.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student {
	
	@Id
	@Column(name = "id_student")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idStudent;

	@Column(name = "school")
	private String school;

	@Lob
	@Column(name = "student_name")
	private String studentName;

	@ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)
	private Set<Teacher> teachers = new HashSet<>();
	
	public void addTeacher(Teacher teacher)
	{
		teacher.getStudents().add(this);
		teachers.add(teacher);
	}
}
