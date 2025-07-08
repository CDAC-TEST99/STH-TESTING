package SmsAndMail;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;




public class SmsAndMailScheduler {

	static Timer timer = null;
	
	
	public static void startSmsAndMailScheduler(int timeInMinForSMSEMailCheck) {
			System.out.println("SmsAndMail scheduler started");
			final Calendar today = Calendar.getInstance();
			today.set(Calendar.HOUR_OF_DAY, 9);
			today.set(Calendar.MINUTE, 45);
			today.set(Calendar.SECOND, 0);

			timer = new Timer();

			timer.scheduleAtFixedRate(new TimerTask() {

				@Override
				public void run() {
					
					try {
						System.out.println("scheduler run @ "+new Date());
						sendmessage sm= new sendmessage();
						sm.ScheduleSMSandMail();
					} 
					catch(Exception e) {
						e.printStackTrace();
						
					} 
					finally {
						
					}
				}
			},today.getTime(), 1000*60*timeInMinForSMSEMailCheck);// every 1 minutes  @ 1:00 pm
		}
		
		
		
		
		
		
		
		
		
		
		
		public static void stopSmsAndMailScheduler() {

			if (timer != null) {

				timer.purge();
				timer.cancel();

				timer = null;
				
			}

		}
		
		
		
}
