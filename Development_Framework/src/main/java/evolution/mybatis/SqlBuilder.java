package evolution.mybatis;

import org.apache.ibatis.jdbc.SQL;

public class SqlBuilder {
	// http://www.mybatis.org/mybatis-3/statement-builders.html
	public String selectBySqlBuilder() {
		return new SQL() {{
			SELECT("id, name");
			FROM("any_table");
			WHERE("name = #{name}");
		}}.toString();
	}
}
