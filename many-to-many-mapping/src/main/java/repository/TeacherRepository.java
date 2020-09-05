package repository;

import org.springframework.data.repository.CrudRepository;

import data.model.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

}
