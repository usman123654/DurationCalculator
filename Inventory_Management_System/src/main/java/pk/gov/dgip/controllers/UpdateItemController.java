package pk.gov.dgip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pk.gov.dgip.entities.Item;
import pk.gov.dgip.entities.User;
import pk.gov.dgip.services.CategoryDAOService;
import pk.gov.dgip.services.ConditionDAOService;
import pk.gov.dgip.services.ItemsDAOService;
import pk.gov.dgip.services.ManufacturerDAOService;
import pk.gov.dgip.services.ProcessorDAOService;
import pk.gov.dgip.services.SectionDAOService;
import pk.gov.dgip.services.SupplierDAOService;
import pk.gov.dgip.services.UserDAOService;

@Controller
public class UpdateItemController {
	
	@Autowired
	private UserDAOService userService;
	
	@Autowired
	private ItemsDAOService itemsService;
	
	@Autowired
	private CategoryDAOService categoryService;
	
	@Autowired
	private ManufacturerDAOService manufacturerService; 
	
	@Autowired
	private ProcessorDAOService processorService;
	
	@Autowired
	private SupplierDAOService supplierService;
	
	@Autowired
	private SectionDAOService sectionService;
	
	@Autowired
	private ConditionDAOService conditionService;
	
	@PostMapping("/items/showFormForUpdate")
	public String showFormForUpdate(@ModelAttribute("items") Item item,Model model) {
		// Get user against item
		User user = item.getUser();
		// Set categories list in the model. 
		model.addAttribute("section",sectionService.getAllSections());
		model.addAttribute("supplier",supplierService.getAllSuppliers());
		model.addAttribute("category",categoryService.getAllCategories());
		model.addAttribute("manufacturer",manufacturerService.getAllManufacturers());
		model.addAttribute("processor",processorService.getAllProcessors());
		model.addAttribute("condition",conditionService.getAllConditions());
		model.addAttribute("item",item);
		model.addAttribute("user",user);
		return "updateItems";
	}
	

	@PostMapping("/items/showFormForUpdateDB")
	public String showFormForUpdateDBSection(@ModelAttribute("items") Item item,Model model) {
		// Get user against item
		User user = item.getUser();
		// Set categories list in the model. 
		model.addAttribute("section",sectionService.getAllSections());
		model.addAttribute("supplier",supplierService.getAllSuppliers());
		model.addAttribute("category",categoryService.getAllCategories());
		model.addAttribute("manufacturer",manufacturerService.getAllManufacturers());
		model.addAttribute("processor",processorService.getAllProcessors());
		model.addAttribute("condition",conditionService.getAllConditions());
		model.addAttribute("item",item);
		model.addAttribute("user",user);
		return "updateItemsDB";
	}

	@PostMapping("/items/update")
	public String showMainPage(@ModelAttribute("item") Item item,@ModelAttribute User user,Model model) {		  
		  User nuser = userService.getUserById(item.getUser().getId());
		  itemsService.updateItem(item);
		  model.addAttribute("userID",nuser.getId());
		  model.addAttribute("items",itemsService.findItemsByUser(nuser));
		  model.addAttribute("rpoName",nuser.getFullname());
		return "showHardware";
	}
	
	@PostMapping("/items/updateDB")
	public String showMainPageDBSection(@ModelAttribute("item") Item item,@ModelAttribute User user,Model model) {	
		  User nuser = userService.getUserById(item.getUser().getId());
		  itemsService.updateItem(item);
		  model.addAttribute("userID",nuser.getId());
		  model.addAttribute("items",itemsService.findItemsByUser(nuser));
		  model.addAttribute("rpoName",nuser.getFullname());
		return "showHardwareDB";
	}
}
