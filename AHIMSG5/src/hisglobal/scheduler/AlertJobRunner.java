package hisglobal.scheduler;

import java.util.Timer;

public class AlertJobRunner {

	static Timer timer = null;

	public static void startScheduler() {
		// TODO Auto-generated method stub

		timer = new Timer();
		
		ScheduledJobTask st = new ScheduledJobTask();

		timer.schedule(st, 1000, 30000);// delay the task 1 second, and then run every 30 seconds

	}

	public static void stopScheduler() {

		if (timer != null) {

			timer.purge();
			timer.cancel();

			timer = null;
			
		}

	}

}