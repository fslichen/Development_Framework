package evolution.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import evolution.pojo.Student;

@Mapper
public interface MapperDemo {
	@Insert("create table if not exists any_table(id int primary key auto_increment, name varchar(20))")
	public void create();
	
	@Insert("insert into any_table(name) values(#{student.name})")
	public void insert(@Param("student") Student student);
	
	@Select("select * from any_table")
	public List<Map<String, Object>> select();
}
