package co.coffeeshop.coffeeshopapp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping("/registration")
	public ModelAndView showRegistration() {
		return new ModelAndView("registration");

	}

	@RequestMapping("/summary")
	public ModelAndView showSummary(User user, @RequestParam("confirm-password") String confirmPassword,
			HttpSession session, RedirectAttributes redir) {

		User existingUser = userDao.findByUsername(user.getUsername());
		if (existingUser != null) {
			// If user already exists, display an error message.
			return new ModelAndView("summary", "message", "A user with that username already exists.");
		}

		if (!confirmPassword.equals(user.getPassword())) {
			// If the user or passwords don't match, display an error message.
			return new ModelAndView("summary", "message", "Passwords do not match.");
		}
		userDao.create(user);

		ModelAndView mv = new ModelAndView("summary");
		mv.addObject("message", "thanks for joining");

		return mv;
	}

}
