package evolution.logger.log4j2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jConsoleDemo {
	private static Logger logger = LogManager.getLogger();
	
	// Please put log4j2.xml under the class path. (src/main/resources)
	public static void main(String[] args) {
		logger.info("The current time is {}.", new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));
	}
}
