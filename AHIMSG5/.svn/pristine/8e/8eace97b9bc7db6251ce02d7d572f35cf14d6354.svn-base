package hisglobal.scheduler;

import java.util.TimerTask;
 

// Create a class extends with TimerTask
public class ScheduledJobTask extends TimerTask {

	// Add your task here
	public void run() {

		//System.out.println("job scheduler running " + new Date());

	 

		try {
 

			 	SMSJob.startSmsJob();
			 	EmailJob.startEmailJob();

			 

		} catch (Exception e) {

			System.err.println(e);

			 
		} finally {
 

		}

	}

}