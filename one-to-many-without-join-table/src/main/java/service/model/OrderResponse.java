package service.model;

import data.model.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse extends Response {

	private Order order;
}
