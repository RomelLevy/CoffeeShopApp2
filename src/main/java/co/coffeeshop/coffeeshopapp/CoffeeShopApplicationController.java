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

	// ADMIN CONTROLS & SETUP
	// ADMIN CONTROLS & SETUP
	// ADMIN CONTROLS & SETUP

	@RequestMapping("/admin/menu")
	public ModelAndView menuItem(@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "category", required = false) String category) {
		ModelAndView mav = new ModelAndView("MenuItem");
		if (keyword != null && !keyword.isEmpty()) {
			mav.addObject("menu", coffeeMenuDao.findByKeyword(keyword));
		} else if (category != null && !category.isEmpty()) {
			mav.addObject("menu", coffeeMenuDao.findByCategory(category));
		} else {
			mav.addObject("menu", coffeeMenuDao.findAll());
		}
		// list of categories needed for <select>
		mav.addObject("categories", coffeeMenuDao.findAllCategories());
		return mav;
	}

	@RequestMapping("/admin/menu/create")
	public ModelAndView showCreateForm() {
		// If there is only one model value to add, use this one-line shortcut.
		// Equivalent to
		// ModelAndView mav = new ModelAndView("food-form");
		// mav.addObject("title", "Add a Food");
		return new ModelAndView("coffee-form", "title", "Add a Coffee");
	}

	@RequestMapping(value = "/admin/menu/create", method = RequestMethod.POST)
	public ModelAndView submitCreateForm(MenuItem menuItem) {
		coffeeMenuDao.create(menuItem);
		return new ModelAndView("redirect:/menu");
	}

	// path variable required to identify which food we're editing
	@RequestMapping("/admin/menu/update")
	public ModelAndView showEditForm(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("coffee-form");
		mav.addObject("menu", coffeeMenuDao.findById(id));
		mav.addObject("title", "Edit MenuItem");
		return mav;
	}

	// same URL but different method
	@RequestMapping(value = "/admin/menu/update", method = RequestMethod.POST)
	public ModelAndView submitEditForm(MenuItem menuItem) {
		coffeeMenuDao.update(menuItem);
		return new ModelAndView("redirect:/menu");
	}

	@RequestMapping("/admin/menu/delete")
	public ModelAndView delete(@RequestParam("id") Long id) {
		coffeeMenuDao.delete(id);
		return new ModelAndView("redirect:/menu");
	}

}
