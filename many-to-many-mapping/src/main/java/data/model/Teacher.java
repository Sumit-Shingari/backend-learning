package data.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "teacher")
@Getter
@Setter
public class Teacher {

	@Id
	@Column(name = "id_teacher")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTeacher;

	@Column(name = "school")
	private String school;

	@Lob
	@Column(name = "teacher_name")
	private String teacherName;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "teacher_student", joinColumns = {
			@JoinColumn(referencedColumnName = "id_teacher") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "id_student") })
	private Set<Student> students = new HashSet<>();

	public void addStudent(Student student) {
		student.getTeachers().add(this);
		students.add(student);
	}
}
