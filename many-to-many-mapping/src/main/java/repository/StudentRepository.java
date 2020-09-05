package repository;

import org.springframework.data.repository.CrudRepository;

import data.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
