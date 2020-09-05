package data.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_table")
@Getter
@Setter
public class Order {
		
	@Id
	@Column(name = "id_order")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrder;

	@Column(name = "order_date")
	private Timestamp orderDate;

	@Lob
	@Column(name = "order_description")
	private String orderDescription;
	
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,mappedBy = "order", orphanRemoval = true)
	@JsonIgnoreProperties("order")
	private Set<ItemMaster> items = new HashSet<>();
	
	public void addChild(ItemMaster item)
	{
		item.setOrder(this);
		items.add(item);
	}
}