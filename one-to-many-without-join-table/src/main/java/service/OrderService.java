package service;

import java.util.Set;

import org.springframework.stereotype.Service;

import data.model.ItemMaster;
import data.model.Order;
import exception.OrderNotFoundException;
import lombok.RequiredArgsConstructor;
import repository.OrderRepository;
import service.model.OrderListResponse;
import service.model.OrderResponse;
import service.model.Response;

@RequiredArgsConstructor
@Service
public class OrderService {

	private final OrderRepository repository;

	public Response getOrders() {

		OrderListResponse orderList = new OrderListResponse();
		orderList.setOrders(repository.findAll());
		return orderList;
	}

	public Response getOrderById(Long id) {
		OrderResponse response = new OrderResponse();
		response.setOrder(repository.findById(id).orElseThrow(OrderNotFoundException::new));
		return response;
	}

	public Response saveOrder(Order order) {
		OrderResponse response = new OrderResponse();
		Set<ItemMaster> items = order.getItems();
		items.stream().forEach(a -> {
			order.addChild(a);
		});
		response.setOrder(repository.save(order));
		return null;
	}

	public Response updateOrder(Long id, Order order) {
		OrderResponse response = new OrderResponse();
		repository.findById(id).orElseThrow(OrderNotFoundException::new);
		Set<ItemMaster> items = order.getItems();
		items.stream().forEach(a -> {
			order.addChild(a);
		});
		repository.save(order);
		response.setOrder(order);
		return response;
	}
}
