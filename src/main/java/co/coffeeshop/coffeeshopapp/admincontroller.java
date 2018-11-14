package co.coffeeshop.coffeeshopapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class admincontroller {
	
	@Autowired
	private CoffeeMenuDao coffeeMenuDao;
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("home");
	
	
	}
	
	@RequestMapping("/admin/menu")
	public ModelAndView listFood(
			@RequestParam(value="keyword", required=false) String keyword,
			@RequestParam(value="category", required=false) String category) {
		ModelAndView mav = new ModelAndView("list-food");
		if (keyword != null && !keyword.isEmpty()) {
			mav.addObject("foods", foodDao.findByKeyword(keyword));
		} else if (category != null && !category.isEmpty()) {
			mav.addObject("foods", foodDao.findByCategory(category));
		} else {
			mav.addObject("foods", foodDao.findAll());
		}
		// list of categories needed for <select>
		mav.addObject("categories", foodDao.findAllCategories());
		return mav;
	}

}
