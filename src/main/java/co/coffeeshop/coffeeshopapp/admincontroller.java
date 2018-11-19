package co.coffeeshop.coffeeshopapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@Autowired
	private CoffeeMenuDao coffeeMenuDao;

	// ADMIN CONTROLS & SETUP
	// List Admin Menu
	@RequestMapping("/admin/menu")
	public ModelAndView menuItem(@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "category", required = false) String category) {

		ModelAndView mav = new ModelAndView("adminmenu");
		if (keyword != null && !keyword.isEmpty()) {
			mav.addObject("menu", coffeeMenuDao.findByKeyword(keyword));
		} else if (category != null && !category.isEmpty()) {
			mav.addObject("menu", coffeeMenuDao.findByCategory(category));
		} else {
			mav.addObject("menu", coffeeMenuDao.findAll());
		}

		mav.addObject("categories", coffeeMenuDao.findAllCategories());
		return mav;
	}
	// Adding items to menu form. 
	@RequestMapping("/admin/menu/create")
	public ModelAndView showCreateForm() {
		return new ModelAndView("coffee-form", "title", "Add a Coffee");
	}
    //Sending new items to DB.
	@RequestMapping(value = "/admin/menu/create", method = RequestMethod.POST)
	public ModelAndView submitCreateForm(MenuItem menuItem) {
		coffeeMenuDao.create(menuItem);
		return new ModelAndView("redirect:/menu");
	}
    // Editing items on menu.
	@RequestMapping("/admin/menu/update")
	public ModelAndView showEditForm(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("coffee-form");
		mav.addObject("menu", coffeeMenuDao.findById(id));
		mav.addObject("title", "Edit menu");
		return mav;
	}
	// Updating menu in DB.
	@RequestMapping(value = "/admin/menu/update", method = RequestMethod.POST)
	public ModelAndView submitEditForm(MenuItem menuItem) {
		coffeeMenuDao.update(menuItem);
		return new ModelAndView("redirect:/menu");
	}
    // Deleting items from menu
	@RequestMapping("/admin/menu/delete")
	public ModelAndView delete(@RequestParam("id") Long id) {
		coffeeMenuDao.delete(id);
		return new ModelAndView("redirect:/admin/menu");
	}

}
