package evolution.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnyController {
	@PostMapping("/post")
	public String post() {
		return "Hello World";
	}
	
	@GetMapping("/get")
	public String get() {
		return "Hello World";
	}
}
