package pk.gov.dgip.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pk.gov.dgip.entities.Item;
import pk.gov.dgip.entities.User;
import pk.gov.dgip.repos.ItemsDataRepository;

@Service
public class ItemsDAOServiceImpl implements ItemsDAOService {
	@Autowired
	private ItemsDataRepository itemsRep;
	@Override
	public Item saveItem(Item item) {
		return itemsRep.save(item);
	}

	@Override
	public Item updateItem(Item item) {
		return itemsRep.save(item);
	}

	@Override
	public void deleteItem(Item item) {
		itemsRep.delete(item);
	}

	@Override
	public Item getItemById(Long id) {	
		return itemsRep.findById(id).get();
	}

	@Override
	public List<Item> getAllItems() {
		return itemsRep.findAll();
	}

	@Override
	public List<Item> findItemsByUser(User user) {
		return itemsRep.findItemsByUser(user);
	}

	@Override
	public Item findBySerialNo(String serialno) {
		return itemsRep.findBySerialNo(serialno);
	}

	@Override
	public Item findByServiceTagNo(String serviceTagNo) {
		return itemsRep.findByServiceTagNo(serviceTagNo);
	}
}
