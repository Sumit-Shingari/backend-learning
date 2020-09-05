package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import data.model.Order;
import lombok.RequiredArgsConstructor;
import service.OrderService;
import service.model.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController {

	private final OrderService service;

	@GetMapping
	public ResponseEntity<Response> getOrder() {
		Response response = service.getOrders();
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	@GetMapping("{id}")
	public ResponseEntity<Response> getOrderById(@PathVariable Long id) {
		Response response = service.getOrderById(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Response> addOrder(@RequestBody Order order) {
	    Response response = service.saveOrder(order);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Response> updateOrder(@PathVariable Long id, @RequestBody Order order) {
		Response response = new Response();
		response = service.updateOrder(id, order);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
