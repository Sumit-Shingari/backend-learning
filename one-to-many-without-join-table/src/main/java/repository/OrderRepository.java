package repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import data.model.Order;


public interface OrderRepository extends CrudRepository<Order, Long> {
	
	@Modifying
	@Transactional
	@Query("delete from ItemMaster")
	void deleteAllItemsWithQuery();
	
	@Modifying
	@Transactional
	@Query("delete from Order")
	void deleteAllOrdersWithQuery();
	

}
