package evolution.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import evolution.pojo.Student;

@RestController
public class MyBatisControllerDemo {
	@Autowired
	private MapperDemo mapperDemo;
	
	@GetMapping("/mybatis")
	public List<Map<String, Object>> select() {
		mapperDemo.create();
		Student student = new Student();
		student.setName("Chen");
		mapperDemo.insert(student);
		return mapperDemo.select();
	}
}
