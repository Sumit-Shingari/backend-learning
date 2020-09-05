package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import service.ItemService;
import service.model.Response;

@RestController
@RequestMapping("items")
@RequiredArgsConstructor
public class ItemController {
	
	private final ItemService service;

	@GetMapping
	public ResponseEntity<Response> getOrder() {
		Response response = service.getItems();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Response> getItemsByOrder(@PathVariable Long id) {
		Response response = service.getItemsByOrder(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
