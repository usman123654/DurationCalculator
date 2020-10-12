package pk.gov.dgip.services;

import java.util.List;
import pk.gov.dgip.entities.Item;
import pk.gov.dgip.entities.User;

public interface ItemsDAOService {
	Item saveItem(Item item);
	Item updateItem(Item item);
	void deleteItem(Item item);
	Item getItemById(Long id);
	List<Item> getAllItems();
	List<Item> findItemsByUser(User user);	
	Item findBySerialNo(String serialno);
	Item findByServiceTagNo(String serviceTagNo);
}
