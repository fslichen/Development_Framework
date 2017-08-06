package evolution.mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages = "evolution")
@EnableTransactionManagement
@ConfigurationProperties(prefix = "spring.datasource")
public class MyBatisConfiguration {
	private String driver;
	private String url;
	private String username;
	private String password;
	
	// Disable the following bean if you would like to use the h2 database.
    @Bean
    public DataSource dataSource() {
        PooledDataSource dataSource = new PooledDataSource(driver, 
        		url, username, password);
        return dataSource;
    }

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
