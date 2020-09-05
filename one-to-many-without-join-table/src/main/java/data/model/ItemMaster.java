package data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;
import serializer.ItemSerializer;

@Entity
@Table(name = "item_master")
@Getter
@Setter
@JsonSerialize(using = ItemSerializer.class)
public class ItemMaster
{
	@Id
	@Column(name = "id_item")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idItem;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "item_desc")
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_order")
	private Order order;
}
