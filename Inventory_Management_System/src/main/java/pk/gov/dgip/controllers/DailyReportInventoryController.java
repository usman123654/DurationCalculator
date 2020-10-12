package pk.gov.dgip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pk.gov.dgip.entities.User;
import pk.gov.dgip.services.ItemsDAOService;
import pk.gov.dgip.services.UserDAOService;


@Controller
public class DailyReportInventoryController {
	
	@Autowired
	private UserDAOService userService;
	
	@Autowired
	private ItemsDAOService itemsService;

	@RequestMapping(value = "/daily-report-inventory", method = RequestMethod.POST)
	public String dailyReportInventoryController (@ModelAttribute(name = "userID") String userid, Model model) {
				model.addAttribute("userid",userid);
				User user = userService.getUserById(Integer.parseInt(userid));
				model.addAttribute("items",itemsService.findItemsByUser(user));
				model.addAttribute("rpoName",user.getFullname());
				return "daily-report-inventory";
	}
}


