package service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import repository.ItemRepository;
import service.model.ItemListResponse;
import service.model.Response;

@Service
@RequiredArgsConstructor
public class ItemService {

	private final ItemRepository repository;

	public Response getItems() {
		ItemListResponse itemList = new ItemListResponse();
		itemList.setItemList(repository.findAll());
		return itemList;
	}

	public Response getItemsByOrder(Long id) {
		ItemListResponse response = new ItemListResponse();
		response.setItemList(repository.getItemsByOrder(id));
		return response;
	}
}
