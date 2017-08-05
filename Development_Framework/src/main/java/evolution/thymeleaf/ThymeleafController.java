package evolution.thymeleaf;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import evolution.controller.dto.Student;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {
	@GetMapping("/get")
	public String thymeleafGet(Model model, HttpServletRequest request) {
		// Request Data
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		System.out.println("Name = " + name + " Gender = " + gender);
		// Response Data
		List<Student> students = new LinkedList<>();
		Student chen = new Student();
		chen.setName("Chen");
		chen.setGender("M");
		Student ling = new Student();
		ling.setName("Ling");
		ling.setGender("F");
		students.addAll(Arrays.asList(chen, ling));
		model.addAttribute("name", name == null ? "Chen" : name);
		model.addAttribute("gender", gender == null ? "M" : gender);
		model.addAttribute("age", "27");
		model.addAttribute("students", students);
		return "thymeleaf";// Redirects to thymeleaf.html under templates folder.
	}
}
