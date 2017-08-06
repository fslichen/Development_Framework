package evolution.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface AnnotationMapper {
	@Insert("create table if not exists any_table(id int primary key auto_increment, name varchar(20))")
	public void create();
	
	@Insert("insert into any_table(name) values(#{student.name})")
	public void insert(@Param("student") Student student);
	
	@Select("select * from any_table")
	public List<Map<String, Object>> select();
	
	// Suitable for static case.
	@SelectProvider(type = SqlBuilder.class, method = "selectBySqlBuilder")
	public List<Student> selectBySelectProvider(@Param("name") String name);
	
	@Select("<script>"
			+ "select * from any_table"
			+ "<if test=\"name != null\">"
			+ "where name = #{name}"
			+ "</if>"
			+ "</script>")
	public List<Student> selectByScript(@Param("name") String name);
}
