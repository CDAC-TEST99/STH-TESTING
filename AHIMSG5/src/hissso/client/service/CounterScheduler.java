package hissso.client.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import hislogin.transactions.utl.LoginFeaturesUTL;

public class CounterScheduler {
	
static Timer timer = null;
	

public static void updateTable() {
    //System.out.println("scheduler counter table started");

    final Calendar today = Calendar.getInstance();
    today.set(Calendar.HOUR_OF_DAY, 0);  // Set hour to 0 (midnight)
    today.set(Calendar.MINUTE, 0);       // Set minute to 0
    today.set(Calendar.SECOND, 0);       // Set second to 0
    today.set(Calendar.MILLISECOND, 0);  // Set millisecond to 0 to ensure exact 12 AM

    // If the time is already past midnight, set it for the next day.
    if (today.getTimeInMillis() < System.currentTimeMillis()) {
        today.add(Calendar.DATE, 1);  // Add one day to the calendar to schedule for the next 12 AM
    }

    // Create a Timer instance
    Timer timer = new Timer();

    timer.scheduleAtFixedRate(new TimerTask() {

        @Override
        public void run() {
            try {
                System.out.println("scheduler counter table run @ " + new Date());

                // Call method to update the table
                LoginFeaturesUTL.updateTable();
            } 
            catch (Exception e) {
                e.printStackTrace();
            } 
            finally {
                // No clean-up needed here for now
            }
        }
    },// today.getTime(), 1000 * 60 * timeInMinForSMSEMailCheck
    		today.getTime(), 1000 * 60 * 60 * 24); // This will run at 12:00 AM and repeat after `timeInMinForSMSEMailCheck` minutes
}

		

}
