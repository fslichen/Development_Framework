package evolution.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jDemo {
	// Logback is used by default in spring boot.
	Logger logger = LoggerFactory.getLogger(Slf4jDemo.class);
	
	// Priority Hierarchy = Trace < Debug < Info < Warn < Error < Fatal
	public static void main(String[] args) {
		Slf4jDemo slf4jLoggerDemo = new Slf4jDemo();
		slf4jLoggerDemo.logger.info("Hello World");
		// {} stands for an argument.
		slf4jLoggerDemo.logger.info("The time is now {}", new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));
	}
}
