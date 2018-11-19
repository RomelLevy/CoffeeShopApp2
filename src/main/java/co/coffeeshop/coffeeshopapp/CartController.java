package co.coffeeshop.coffeeshopapp;

import java.util.List;

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

	// Adding items to cart.
	@RequestMapping("/add-to-cart")
	public ModelAndView addToCart(@RequestParam("id") Long menuItemId) {
		MenuItem m = coffeeMenuDao.findById(menuItemId);
		CartItem c = new CartItem();
		c.setQuantity(1);
		c.setMenuItem(m);
		cartItemDAO.create(c);
		return new ModelAndView("redirect:/cart");
	}

	// Showing items in cart.
	@RequestMapping("/cart")
	public ModelAndView showCart() {
		List<CartItem> leListOfCartItems = cartItemDAO.findAll();
		return new ModelAndView("cart", "cartitems", leListOfCartItems);
	}

	// Removing items from cart.
	@RequestMapping("/remove-from-cart")
	public ModelAndView delete(@RequestParam("id") Long id) {
		cartItemDAO.delete(id);
		return new ModelAndView("redirect:/cart");
	}

}
