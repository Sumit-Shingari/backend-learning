package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import service.BuildingService;
import service.model.Response;

@RestController
public class BuildingController 
{
	private final BuildingService service;
	
	public BuildingController(BuildingService service) {
		this.service = service;
	}

	@PostMapping(value = "/save-building")
	public ResponseEntity<Response> savebuilding() 
	{
		Response response = service.saveBuilding();
		if (response instanceof Response)
			return new ResponseEntity<>(response, HttpStatus.OK);
		else
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value ="/get-building")
	public ResponseEntity<Response> getBuilding(@RequestParam int idBuilding) 
	{
		Response response = service.getBuilding(idBuilding);
		if (response instanceof Response)
			return new ResponseEntity<>(response, HttpStatus.OK);
		else
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(value = "/update-building")
	public ResponseEntity<Response> updatebuilding() 
	{
		Response response = service.updateBuilding();
		if (response instanceof Response)
			return new ResponseEntity<>(response, HttpStatus.OK);
		else
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
}
