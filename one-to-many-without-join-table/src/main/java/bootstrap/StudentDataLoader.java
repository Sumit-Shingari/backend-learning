package bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import data.model.Student;
import lombok.RequiredArgsConstructor;
import repository.StudentRepository;

@Component
@RequiredArgsConstructor
public class StudentDataLoader implements ApplicationListener<ContextRefreshedEvent> {
 
    private final StudentRepository repository;
 
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        
    	repository.deleteAllStudentsWithQuery();
    	
    	Student student_a = new Student();
        student_a.setFirstName("Jane");
        student_a.setLastName("Doe");
        student_a.setYear("Junior");
        repository.save(student_a);
         
        Student student_b = new Student();
        student_b.setFirstName("Martin");
        student_b.setLastName("Fowler");
        student_b.setYear("Senior");
        repository.save(student_b);
         
        Student student_c = new Student();
        student_c.setFirstName("Roy");
        student_c.setLastName("Fielding");
        student_c.setYear("Freshman");
        repository.save(student_c);
    }
}
