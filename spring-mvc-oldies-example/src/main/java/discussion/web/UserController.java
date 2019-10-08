package discussion.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
@Scope("request")
public class UserController {

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		model.addAttribute(new UserForm());
		return "/user/userForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processForm(@ModelAttribute UserForm userFrom, Errors errors) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Neuer User mit ID " + new Long(1) + " angelegt.");
		mav.setViewName("/user/userForm");
		return mav;
	}

}
