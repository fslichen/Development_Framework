package evolution.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import evolution.pojo.Student;

/**
 * RestController incorporates @ResponseBody
 * @ResponseBody renders JSON by default.
 */
@RestController
public class RestControllerDemo {
	@PostMapping("/post")
	public Student post(@RequestBody Student student) {
		return student;
	}
	
	@GetMapping("/get")
	public String get() {
		return "{\"name\" : \"Chen\"}";// JSON string is rendered as return value.
	}
	
	@PostMapping("/date")
	public Student date(@RequestBody Student student) {
		return student;
	}
}
