package evolution.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleDemo {
	Logger logger = LoggerFactory.getLogger(ScheduleDemo.class);
	
	/**
	 * Cron expression can also be applied, see http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html
	 */
	@Scheduled(fixedRate = 5000)
	public void runScheduledTask() {
		logger.info("The current time is {}.", new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));
	}
}
