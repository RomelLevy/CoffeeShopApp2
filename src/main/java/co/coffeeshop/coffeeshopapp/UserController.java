package co.coffeeshop.coffeeshopapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@RequestMapping("/registration")
	public ModelAndView showRegistration() {
		return new ModelAndView("registration");

	}

	@RequestMapping("/summary")
	public ModelAndView showSummary(@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("email") String email,
			@RequestParam("number") int number, @RequestParam("password") String password) {
		ModelAndView mv = new ModelAndView("summary");

		return mv;
	}

}



//@RequestMapping("/summary")
//public ModelAndView showSummary(@RequestParam("firstname") String firstname,
//		@RequestParam("lastname") String lastname, @RequestParam("email") String email,
//		@RequestParam("number") int number, @RequestParam("password") String password) {
//	ModelAndView mv = new ModelAndView("summary");
//	mv.addObject("firstname", firstname);
//	mv.addObject("lastname", lastname);
//	mv.addObject("email", email);
//	mv.addObject("number", number);
//	mv.addObject("password", password);
//
//	return mv;
