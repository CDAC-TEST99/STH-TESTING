package formFlowX.listner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import SmsAndMail.SmsAndMailScheduler;

public class EmailListner implements ServletContextListener {
	
	

	//private static int timeInHrForComplaintClose;
	
	public void contextInitialized(ServletContextEvent objContextEvent)
	{
		System.out.println("starting maillistner");
		
		
		
			SmsAndMailScheduler.startSmsAndMailScheduler(3);		
		
		
	}

	public void contextDestroyed(ServletContextEvent objContextEvent)
	{
		
			SmsAndMailScheduler.stopSmsAndMailScheduler();
			 
	}

}
