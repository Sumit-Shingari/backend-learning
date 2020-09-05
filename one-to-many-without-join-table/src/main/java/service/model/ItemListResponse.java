package service.model;

import data.model.ItemMaster;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemListResponse extends Response {

	private Iterable<ItemMaster> itemList;
}
