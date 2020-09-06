package repository;

import org.springframework.data.repository.CrudRepository;

import data.model.Complex;

public interface ComplexReposittory extends CrudRepository<Complex, Integer> {

}
