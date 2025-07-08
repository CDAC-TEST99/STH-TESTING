package thirdpartyservices.bharatkosh.service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;

import hisglobal.utility.Usefulmethods;

public class BKPayTrackScheduler {
	private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	public static void scheduleAtSpecificTime(int hour, int minute) {
		Runnable task = () -> {
		//	System.out.println("=================== Start Bharatkosh Scheduler Running Time = " + hour + " " + minute + "PM");
			try {
				JSONObject objResponse = new JSONObject();

				Usefulmethods objUsefulmethods = new Usefulmethods();
				String strServiceName = "service/trackBKPaymentStatus";

				// Call the service and get the response
				objResponse = objUsefulmethods.callService(null, strServiceName);
				new BharatkoshClientRestApi().trackBKPayStatus(objResponse.toString());
				
			//	System.out.println("================== End Bharatkosh Task executed at specific time: " + LocalDateTime.now());
			} catch (Exception e) {
				e.printStackTrace();
			}
		};

		long initialDelay = computeInitialDelay(hour);

		scheduler.scheduleAtFixedRate(task, initialDelay, 24, TimeUnit.HOURS);
		
	}

	public static void startScheduler() {
		scheduleAtSpecificTime(17, 0);
		
	}

	private static long computeInitialDelay(int targetHour) {
		LocalTime now = LocalTime.now();
		LocalTime targetTime = LocalTime.of(targetHour, 0);
		if (now.isAfter(targetTime)) {
			targetTime = targetTime.plusHours(24);
		}
		return Duration.between(now, targetTime).getSeconds();
	}
}
