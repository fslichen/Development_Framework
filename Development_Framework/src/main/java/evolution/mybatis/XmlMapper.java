package evolution.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface XmlMapper {
	public List<Map<String, Object>> selectMaps();
	
	public List<Student> selectAllStudents();
}
