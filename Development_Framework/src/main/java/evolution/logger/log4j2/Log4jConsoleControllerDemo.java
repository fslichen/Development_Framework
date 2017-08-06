package evolution.logger.log4j2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Log4jConsoleControllerDemo {
	private static Logger logger = LogManager.getLogger();
	
	// Please put log4j2.xml under the class path. (src/main/resources)
	@GetMapping("/log4j/console")
	public void log() {
		logger.info("The current time is {}.", new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));
	}
}
