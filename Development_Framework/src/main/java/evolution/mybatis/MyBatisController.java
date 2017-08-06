package evolution.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/annotation")
	public List<Map<String, Object>> annotation() {
		annotationMapper.create();
		Student student = new Student();
		student.setName("Chen");
		annotationMapper.insert(student);
		return annotationMapper.select();
	}
	
	@GetMapping("/xml/maps")
	public List<Map<String, Object>> selectMapsByXml() {
		return xmlMapper.selectMaps();
	}
	
	@GetMapping("/xml/all/students")
	public List<Student> selectAllStudentsByXml() {
		return xmlMapper.selectAllStudents();
	}
}
