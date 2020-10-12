package pk.gov.dgip.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pk.gov.dgip.entities.Item;
import pk.gov.dgip.entities.User;
import pk.gov.dgip.services.DataDAO;
import pk.gov.dgip.services.DataDAOImpl;
import pk.gov.dgip.services.ItemsDAOService;
import pk.gov.dgip.services.UserDAOService;

@RestController
public class ReportController {
	@Autowired
	private UserDAOService userService;
	@Autowired
	private ItemsDAOService itemsService;

	List<Item> items = new ArrayList<>();
	List<pk.gov.dgip.entities.Data> rposData = new ArrayList<>();

	@RequestMapping("/report/inventory")
	public @ResponseBody List<?> getAllProducts(@RequestParam("username") String fullname) {
		if (fullname.equals("All Regional Offices and Missions Abroad")) {
			DataDAO datadao = new DataDAOImpl();
			rposData = datadao.findAll();
			return rposData;
		} else {
			User user = userService.findUserByFullName(fullname);
			items = itemsService.findItemsByUser(user);
			return items;
		}
	
	}

	@RequestMapping("/report/allRPOsData")
	@ResponseBody
	public List<?> reportAllRPOsData() {
		return rposData;
	}
	
	@RequestMapping("/report/allitems")
	@ResponseBody
	public List<?> reportAllItems() {
		return items;
	}
}
