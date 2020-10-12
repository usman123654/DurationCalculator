package pk.gov.dgip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pk.gov.dgip.entities.Condition;
import pk.gov.dgip.entities.Item;
import pk.gov.dgip.entities.Manufacturer;
import pk.gov.dgip.entities.Processor;
import pk.gov.dgip.entities.Supplier;

@Controller
public class SaveItems {
	
	@PostMapping("/items/save")
	public String saveItems(@RequestParam("Id") String userid,@ModelAttribute("manufacturer") Manufacturer manufacturer,@ModelAttribute("processor") Processor processor,@ModelAttribute("item") Item item,@ModelAttribute("supplier") Supplier supplier,@ModelAttribute("condition") Condition condition) {
		return "addItems";
	}
}
