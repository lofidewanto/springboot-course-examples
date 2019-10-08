package discussion.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@RequestMapping({ "/helloWorld", "/" })
	public String helloWorld(Model model) {
		model.addAttribute("Hello World");
		return "helloWorld";
	}

}
