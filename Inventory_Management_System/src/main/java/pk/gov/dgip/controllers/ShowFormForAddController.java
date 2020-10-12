package pk.gov.dgip.controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
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
public class ShowFormForAddController {
	
private List<String> itemsList;
@Autowired
private UserDAOService userService;
@Autowired
private ItemsDAOService itemsService;
@Autowired
private ManufacturerDAOService manufacturerService;
@Autowired
private ProcessorDAOService processorService;
@Autowired
private CategoryDAOService categoryService;
@Autowired
private SupplierDAOService supplierService;
@Autowired
private SectionDAOService sectionService;
@Autowired
private ConditionDAOService conditionService;


	@PostMapping("/items/showFormForAdd")
	public String showFormForAdd(@RequestParam("userID") String userid,Model model) {
		// user id in the string
		model.addAttribute("userid",userid);
		// create model attribute to bind form data
		User user = userService.getUserById(Integer.parseInt(userid));
		Item item = new Item();
		model.addAttribute("section",sectionService.getAllSections());
        model.addAttribute("supplier",supplierService.getAllSuppliers());
		model.addAttribute("category",categoryService.getAllCategories());
		model.addAttribute("processor",processorService.findAllByOrderByNameAsc());
		model.addAttribute("manufacturer",manufacturerService.getAllManufacturers());
		model.addAttribute("condition",conditionService.getAllConditions());
		model.addAttribute("item",item);
		model.addAttribute("user",user);
		return "addItems";
	}
	
	@PostMapping("/items/showFormForAddDB")
	public String showFormForAddDB(@RequestParam("userID") String userid,Model model) {
		// user id in the string
		model.addAttribute("userid",userid);
		// create model attribute to bind form data
		User user = userService.getUserById(Integer.parseInt(userid));
		Item item = new Item();
		model.addAttribute("section",sectionService.getAllSections());
        model.addAttribute("supplier",supplierService.getAllSuppliers());
		model.addAttribute("category",categoryService.getAllCategories());
		model.addAttribute("processor",processorService.findAllByOrderByNameAsc());
		model.addAttribute("manufacturer",manufacturerService.getAllManufacturers());
		model.addAttribute("condition",conditionService.getAllConditions());
		model.addAttribute("item",item);
		model.addAttribute("user",user);
		return "addItemsDB";
	}
	

	
	@PostMapping(value = "/home/test")
    public ModelAndView details(@RequestBody String name, HttpServletRequest request,
        HttpServletResponse response) {

        ModelAndView view = new ModelAndView();
        
        System.out.println(name+"is the name of the user");
        view.setViewName("Welcome to ajax");

    return view;
}
}
