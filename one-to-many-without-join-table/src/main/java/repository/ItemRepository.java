package repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import data.model.ItemMaster;

public interface ItemRepository extends CrudRepository<ItemMaster, Long> {

	@Transactional
	@Query("select it from ItemMaster it where it.order.idOrder = :idOrder")
	Iterable<ItemMaster> getItemsByOrder(@Param ("idOrder") Long id); 
}
