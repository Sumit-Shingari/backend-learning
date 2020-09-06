package service;

import org.springframework.stereotype.Service;

import data.model.Complex;
import exceptions.ComplexNotFoundException;
import exceptions.NoDataFoundException;
import lombok.RequiredArgsConstructor;
import repository.ComplexReposittory;

@Service
@RequiredArgsConstructor
public class ComplexService {

	private final ComplexReposittory repository;
	
	public void getAllConplex() {
		Iterable<Complex> complexs = repository.findAll();
		
		if (!complexs.iterator().hasNext())
		{
			throw new NoDataFoundException();
		}
	}

	public void getComplexById(Integer id) {
		repository.findById(id).orElseThrow(ComplexNotFoundException::new);
	}

}
