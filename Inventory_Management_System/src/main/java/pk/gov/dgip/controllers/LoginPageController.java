package pk.gov.dgip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pk.gov.dgip.services.ItemsDAOServiceImpl;
import pk.gov.dgip.services.UserDAOServiceImpl;

@Controller
public class LoginPageController {
	
	@Autowired
	private ItemsDAOServiceImpl itemsService;
	
	@Autowired
	private UserDAOServiceImpl userService;
		// To get a logging form
		@RequestMapping(value="/",method=RequestMethod.GET)
		public String showLoginForm() {
			// return html page name
			return "loginPage";
		}
		
}
