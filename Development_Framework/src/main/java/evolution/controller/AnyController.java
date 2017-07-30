package evolution.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnyController {
	@GetMapping("/thymeleaf/get")
	public String thymeleafGet(Model model, HttpServletRequest request) {
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		model.addAttribute("name", name == null ? "Chen" : name);
		model.addAttribute("gender", gender == null ? "M" : gender);
		return "thymeleaf";// Redirects to thymeleaf.html under templates folder.
	}
}
