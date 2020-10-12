package pk.gov.dgip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pk.gov.dgip.entities.Item;
import pk.gov.dgip.entities.User;
import pk.gov.dgip.services.ItemsDAOService;
import pk.gov.dgip.services.UserDAOService;

@Controller
public class DeleteItemsController {
	
	@Autowired
	private UserDAOService userService;
	
	@Autowired
	private ItemsDAOService itemsService;
	
	private String temp_userid=null;
	
	@RequestMapping(value="/delete/rpoItems",method = RequestMethod.POST)
	public String deleteItemsAgainstUser(@ModelAttribute("items") Item item,Model model)  {
		    
		    User user = item.getUser();

		    itemsService.deleteItem(item);
		    
			model.addAttribute("items",itemsService.findItemsByUser(user));
			model.addAttribute("userID",user.getId());
			model.addAttribute("rpoName",user.getFullname());
			
			return "showHardware";
	} 
	
	@RequestMapping(value="/delete/DatabaseItems",method = RequestMethod.POST)
	public String deleteItemsAgainstDBSection(@ModelAttribute("items") Item item,Model model)  {
		    
		    User user = item.getUser();

		    itemsService.deleteItem(item);
		    
			model.addAttribute("items",itemsService.findItemsByUser(user));
			model.addAttribute("userID",user.getId());
			model.addAttribute("rpoName",user.getFullname());
			
			return "showHardwareDB";
	} 
	
}
