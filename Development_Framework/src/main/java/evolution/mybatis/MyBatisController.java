package evolution.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mybatis")
public class MyBatisController {
	@Autowired
	private AnnotationMapper annotationMapper;
	
	@Autowired
	private XmlMapper xmlMapper;
	
	@GetMapping("/annotation/initialize")
	public List<Map<String, Object>> initializeByAnnotation() {
		annotationMapper.create();
		Student student = new Student();
		student.setName("Chen");
		annotationMapper.insert(student);
		return annotationMapper.select();
	}
	
	@GetMapping("/xml/initialize")
	public List<Student> initializeByXml() {
		xmlMapper.create();
		Student student = new Student();
		student.setName("Chen");
		xmlMapper.insert(student);
		return xmlMapper.selectAllStudents();
	}
	
	@GetMapping("/xml/maps")
	public List<Map<String, Object>> selectMapsByXml() {
		return xmlMapper.selectMaps();
	}
	
	@GetMapping("/xml/all/students")
	public List<Student> selectAllStudentsByXml() {
		return xmlMapper.selectAllStudents();
	}
	
	@GetMapping("/xml/insert/transactional")
	@Transactional// Rolls back once there is an exception within this method.
	public int insertByXmlUsingTransaction() {
		Student student = new Student();
		student.setName("Elsa");
		xmlMapper.insert(student);// The record is not yet inserted into the DB.
		int x = 1 / 0;
		return x;
	}
	
	@GetMapping("/annotation/select/provider")
	public List<Student> selectBySelectProvider() {
		return annotationMapper.selectBySelectProvider("Chen");
	}
	
	@GetMapping("/annotation/script")
	public List<Student> selectByScript() {
		return annotationMapper.selectByScript("Chen");
	}
}
