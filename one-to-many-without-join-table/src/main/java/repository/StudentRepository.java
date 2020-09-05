package repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import data.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	 
	@Modifying
	@Transactional
	@Query("delete from Student")
	void deleteAllStudentsWithQuery();
}
