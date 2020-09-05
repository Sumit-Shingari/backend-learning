package bootstrap;

import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import data.model.ItemMaster;
import data.model.Order;
import lombok.RequiredArgsConstructor;
import repository.OrderRepository;

@Component
@RequiredArgsConstructor
public class OrderDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private final OrderRepository repository;
	
	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		repository.deleteAllItemsWithQuery();
		
		repository.deleteAllOrdersWithQuery();
		
		
		ItemMaster item1 = new ItemMaster();
		item1.setItemName("paste");
		item1.setDescription("new product");
		
		ItemMaster item2 = new ItemMaster();
		item2.setItemName("brush");
		item2.setDescription("newest product");
		
		ItemMaster item3 = new ItemMaster();
		item3.setItemName("clothes");
		item3.setDescription("brand new");
		
		ItemMaster item4 = new ItemMaster();
		item4.setItemName("belt");
		item4.setDescription("pure leather");
	
		Order order1 = new Order();
		order1.setOrderDescription("order 1 desc");
		order1.setOrderDate(new Timestamp(System.currentTimeMillis()));
		
		Order order2 = new Order();
		order2.setOrderDescription("order 2 desc");
		order2.setOrderDate(new Timestamp(System.currentTimeMillis()));

		order1.addChild(item1);
		order1.addChild(item2);
		
		order2.addChild(item3);
		order2.addChild(item4);
		
		repository.save(order1);
		repository.save(order2);
		
	}
	
}