package thirdpartyservices.bhavishya.scheduler;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;

import hisglobal.utility.Usefulmethods;
import thirdpartyservices.bhavishya.service.BhavishyaIntegrationService;
import thirdpartyservices.bhavishya.util.AESEncrytionDecryption;

public class CustomScheduler {
	private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	public static void scheduleAtSpecificTime(int hour, int minute) {
		Runnable task = () -> {
		//	System.out.println("=================== Start Bhavishya Scheduler Running Time = " + hour + " " + minute + "PM");
			try {
				JSONObject objResponse = new JSONObject();

				Usefulmethods objUsefulmethods = new Usefulmethods();
				String strServiceName = "service/getCurrentDayCardIssueDetail";

				// Call the service and get the response
				objResponse = objUsefulmethods.callService(null, strServiceName);
				JSONArray data = new JSONArray();
				data = (JSONArray) objResponse.get("data");
				//System.out.println("Data To Be Inserted By Calling Bhavishya API = " + data.toString());
				String encryptedPanCardData = AESEncrytionDecryption.encrypt(data.toString());

				BhavishyaIntegrationService.getCurrentDayBhavishyaRetireeCardIssuerDetails(encryptedPanCardData);

			//	System.out.println("================== End Bhavishya Task executed at specific time: " + LocalDateTime.now());
			} catch (Exception e) {
				e.printStackTrace();
			}
		};

		long initialDelay = computeInitialDelay(hour);

		scheduler.scheduleAtFixedRate(task, initialDelay, 24, TimeUnit.HOURS);
		
//		scheduler.scheduleAtFixedRate(task, 0, 15, TimeUnit.MINUTES); // Run in every 15 minutes for testing purpose
	}

	public static void startScheduler() {
		int dayTime = Integer.parseInt(Usefulmethods.getQuery("thirdpartyservices.bhavishya.service.cghs-bhavishya",
				"cghs.bhavishya.scheduler.running.day.time"));
		//System.out.println("######### Bhavishya API - Save Card Status - Call Time -> " + dayTime + " hour");
		scheduleAtSpecificTime(dayTime, 0);
		
//		int nightTime = Integer.parseInt(Usefulmethods.getQuery("thirdpartyservices.bhavishya.service.cghs-bhavishya",
//				"cghs.bhavishya.scheduler.running.night.time"));
//		scheduleAtSpecificTime(nightTime, 0);
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
