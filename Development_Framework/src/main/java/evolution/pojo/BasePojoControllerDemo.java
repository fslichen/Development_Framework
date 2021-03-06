package evolution.pojo;

import java.lang.reflect.Field;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasePojoControllerDemo {
	@GetMapping("/pojo")
	public void pojo() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Student student = new Student();
		student.setName("Chen");
		student.setGender("M");
		BaseDto baseDto = student;
		// Reflect is able to get the field at runtime even if the field is not visibly declared. 
		Field genderFiled = baseDto.getClass().getDeclaredField("gender");
		genderFiled.setAccessible(true);
		Object gender = genderFiled.get(baseDto);
		System.out.println(gender);
	}
}
