package service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import data.model.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderListResponse extends Response {

	@JsonIgnoreProperties("items.order")
	private Iterable<Order> orders;
}
