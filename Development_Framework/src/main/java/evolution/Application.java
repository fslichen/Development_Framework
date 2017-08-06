package evolution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {
	/**
	 * You are allowed to have only one main class in spring boot application.
	 * Once you define multiple main classes, you will encounter a problem when packaging your project.
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
}
