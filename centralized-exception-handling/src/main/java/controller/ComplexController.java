package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import service.ComplexService;

@RestController
@RequiredArgsConstructor
@RequestMapping("complex")
public class ComplexController {

	private final ComplexService service;
	
	@GetMapping
	public void getAllComplex() {
	service.getAllConplex();	
	}
	
	@GetMapping("{id}")
	public void getComplexById(@PathVariable Integer id) {
		service.getComplexById(id);
	}
}
