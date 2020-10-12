package pk.gov.dgip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserDataController {
	@RequestMapping("/")
	public String showLoginPage() {
		return "index";
	}
}
