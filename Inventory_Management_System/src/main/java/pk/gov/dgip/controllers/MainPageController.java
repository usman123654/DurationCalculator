package pk.gov.dgip.controllers;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pk.gov.dgip.LoginForm;
import pk.gov.dgip.entities.Item;
import pk.gov.dgip.entities.Role;
import pk.gov.dgip.entities.Supplier;
import pk.gov.dgip.entities.User;
import pk.gov.dgip.services.ItemsDAOService;
import pk.gov.dgip.services.SupplierDAOService;
import pk.gov.dgip.services.UserDAOService;

@Controller
public class MainPageController {

	@Autowired
	private UserDAOService userService;

	@Autowired
	private ItemsDAOService itemsService;
	
	@Autowired
	private SupplierDAOService supplierService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MainPageController.class);

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showMainPage(@ModelAttribute(name = "log") LoginForm login, Model model) {
		User user = userService.findByNameAndPassword(login.getUsername(), login.getPassword());
		if (!(user == null)) {
			List<Role> userRoles = user.getRoles();
			Iterator iterator = userRoles.iterator();
			while (iterator.hasNext()) {
				Role role = (Role) iterator.next();
				if (role.getRole_name().equals("admin")) {	
					List<User> users = userService.getAllUsers();
					Collections.sort(users,User.UserNameComparator);
					model.addAttribute("users",users);
					model.addAttribute("rpoName",user.getFullname());
					model.addAttribute("user",user);
					
					LOGGER.info("USER ID "+user.getId()+" LOGGED IN AT "+ new java.util.Date());
					
					return "adminPage";
					
				} else if(role.getRole_name().equals("user")){
					
					
					List<Supplier> listSuppliers = supplierService.getAllSuppliers();
					model.addAttribute("rpoName", user.getFullname());
					// get hardware items from db
					List<Item> items = itemsService.findItemsByUser(user);
					// add items to the spring model
					model.addAttribute("items", items);
					model.addAttribute("userID", user.getId());
					System.out.println(user.getId()+"is the id of the user");
					
					LOGGER.info("INFO:"+"USER ID "+user.getId()+" LOGGED IN AT "+ new java.util.Date());
					
					return "showHardware";
				} else if(role.getRole_name().equals("dbsection")) {
					
					List<Supplier> listSuppliers = supplierService.getAllSuppliers();
					model.addAttribute("rpoName", user.getFullname());
					System.out.println(user.getId()+"is the id of the user");
					// get hardware items from db
					List<Item> items = itemsService.findItemsByUser(user);
					// add items to the spring model
					model.addAttribute("items", items);
					model.addAttribute("userID", user.getId());
					
					LOGGER.info("INFO:"+"USER ID "+user.getId()+" LOGGED IN AT "+ new java.util.Date());
					
					return "showHardwareDB";
				}
			}
		}
		model.addAttribute("invalidCredentials", true);
		return "loginPage";
	}
	
	@RequestMapping(value="/items/showMainPage",method = RequestMethod.POST)
	public String backtoMainPage(@ModelAttribute User user,@ModelAttribute("items") Item item,Model model)  {
		    
		    User nuser = userService.getUserById(user.getId());
		    System.out.println("The user has items"+nuser.getItems());
		    model.addAttribute("items",itemsService.findItemsByUser(user));
			model.addAttribute("userID",nuser.getId());
			model.addAttribute("rpoName",nuser.getFullname());
			
			LOGGER.info("USER "+user.getId()+" BACK TO MAIN PAGE AT "+ new java.util.Date());
			
			return "showHardware";
	} 
	
	@RequestMapping(value="/items/showMainPageDB",method = RequestMethod.POST)
	public String backtoMainPageDB(@ModelAttribute User user,@ModelAttribute("items") Item item,Model model)  {
		    
		    User nuser = userService.getUserById(user.getId());
		    
		    model.addAttribute("items",itemsService.findItemsByUser(nuser));
			model.addAttribute("userID",nuser.getId());
			model.addAttribute("rpoName",nuser.getFullname());
			
			LOGGER.info("USER "+user.getId()+" BACK TO MAIN PAGE AT "+ new java.util.Date());
			
			return "showHardwareDB";
	} 
}
