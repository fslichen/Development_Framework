package evolution.controller;

import java.lang.reflect.Field;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import evolution.controller.dto.BaseDto;
import evolution.controller.dto.Student;

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
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		BaseDto baseDto = new Student("Chen", "M");
		// Reflect is able to get the field at runtime even if the field is not visibly declared. 
		Field genderFiled = baseDto.getClass().getDeclaredField("gender");
		genderFiled.setAccessible(true);
		Object gender = genderFiled.get(baseDto);
		System.out.println(gender);
	}
}
