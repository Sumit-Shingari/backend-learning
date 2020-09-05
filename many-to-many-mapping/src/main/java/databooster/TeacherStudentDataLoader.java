package databooster;

import javax.transaction.Transactional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import data.model.Student;
import data.model.Teacher;
import lombok.RequiredArgsConstructor;
import repository.TeacherRepository;

@Component
@RequiredArgsConstructor
public class TeacherStudentDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private final TeacherRepository repository;
	
	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Teacher teacher1 = new Teacher();
		teacher1.setSchool("DPS");
		teacher1.setTeacherName("Malik");
		
		Teacher teacher2 = new Teacher();
		teacher2.setSchool("sanatan");
		teacher2.setTeacherName("arjun");

		Student student1 = new Student();
		student1.setSchool("dps");
		student1.setStudentName("amit");
		
		Student student2 = new Student();
		student2.setSchool("kindles");
		student2.setStudentName("preeti");
		
		teacher1.addStudent(student1);
		student1.addTeacher(teacher1);
	
		teacher1.addStudent(student2);
		student2.addTeacher(teacher1);
		
		teacher2.addStudent(student1);
		student1.addTeacher(teacher2);
		
		teacher2.addStudent(student2);
		student2.addTeacher(teacher2);
		
		repository.save(teacher1);
		repository.save(teacher2);		
	}
	
}