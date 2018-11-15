package co.coffeeshop.coffeeshopapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {

	@Autowired
	private CartItemDAO cartItemDAO;
	@Autowired
	private CoffeeMenuDao coffeeMenuDao;

	@RequestMapping("/add-to-cart")
	public ModelAndView addToCart(@RequestParam("id") Long menuItemId) {
		MenuItem m = coffeeMenuDao.findById(menuItemId);
		CartItem c = new CartItem();
		c.setQuantity(1);
		c.setMenuItem(m);
		cartItemDAO.create(c);
		return new ModelAndView("redirect:/cart");
	}

	@RequestMapping("/cart")
	public ModelAndView showCart() {

		ModelAndView mv = new ModelAndView("cart");
		return mv;
	}
}
