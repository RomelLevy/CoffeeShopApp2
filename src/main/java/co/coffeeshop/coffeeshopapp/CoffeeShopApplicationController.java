package co.coffeeshop.coffeeshopapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeShopApplicationController {

	@Autowired
	private CoffeeMenuDao coffeeMenuDao;

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("home");

	}

	@RequestMapping("/menu")
	public ModelAndView MenuItem() {
		List<MenuItem> leListOfMenuItems = coffeeMenuDao.findAll();
		return new ModelAndView("menu", "menuitems", leListOfMenuItems);

	}

}
