package evolution.thymeleaf;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import evolution.controller.dto.Student;

@Controller
public class ThymeleafController {
	@GetMapping("/thymeleaf/get")
	public String thymeleafGet(Model model, HttpServletRequest request) {
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		List<Student> students = new LinkedList<>();
		students.addAll(Arrays.asList(new Student("Chen", "M"), new Student("Ling", "F")));
		model.addAttribute("name", name == null ? "Chen" : name);
		model.addAttribute("gender", gender == null ? "M" : gender);
		model.addAttribute("age", "27");
		model.addAttribute("students", students);
		return "thymeleaf";// Redirects to thymeleaf.html under templates folder.
	}
}
