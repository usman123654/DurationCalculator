package pk.gov.dgip.controllers;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pk.gov.dgip.entities.Item;
import pk.gov.dgip.entities.User;
import pk.gov.dgip.services.ItemsDAOService;
import pk.gov.dgip.services.UserDAOService;

@RestController
public class AddItemsController {
	@Autowired
	private ItemsDAOService itemsService;

	@Autowired
	private UserDAOService userService;

	@PostMapping(value = "/test/get_time.htm")
	public synchronized String addToArrayList(@RequestParam("Id") String useride, @ModelAttribute Item item) throws SQLException {
		User user = userService.getUserById(Integer.parseInt(useride));
		item.setUser(user);
		if(item.getSerialNo().isBlank() & item.getServiceTagNo().isBlank()) {
			throw new SQLException();
		} else if(item.getSerialNo().isBlank()&!(item.getServiceTagNo().isBlank())) {
			String service_tag_no = item.getServiceTagNo();
			if(itemsService.findByServiceTagNo(service_tag_no)==null) {
				itemsService.saveItem(item);
			} else {
				throw new SQLException();
			}
		} else if(!(item.getSerialNo().isBlank())&item.getServiceTagNo().isBlank()) {
			String serial_no = item.getSerialNo();
			if(itemsService.findBySerialNo(serial_no)==null) {
				itemsService.saveItem(item);
			} else {
				throw new SQLException();
			}
		} else if(!(item.getSerialNo().isBlank())&!(item.getServiceTagNo().isBlank())) {
		    String serial_no = item.getSerialNo();
			String service_tag_no = item.getServiceTagNo();
			if(itemsService.findBySerialNo(serial_no)==null && itemsService.findByServiceTagNo(service_tag_no)==null) {
				System.out.println("if block being called");
				itemsService.saveItem(item);			
			} else {
				System.out.println("SQLException executing...");
				throw new SQLException();
			}
		} 
		return "";
	}
}
