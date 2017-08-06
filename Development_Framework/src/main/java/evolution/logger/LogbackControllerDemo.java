package evolution.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogbackControllerDemo {
	// Logback is used by default in spring boot.
	Logger logger = LoggerFactory.getLogger(LogbackControllerDemo.class);
	
	// Priority Hierarchy = Trace < Debug < Info < Warn < Error < Fatal
	@GetMapping("/logback")
	public void log() {
		LogbackControllerDemo slf4jLoggerDemo = new LogbackControllerDemo();
		slf4jLoggerDemo.logger.info("Hello World");
		// {} stands for an argument.
		slf4jLoggerDemo.logger.info("The time is now {}", new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));
	}
}
