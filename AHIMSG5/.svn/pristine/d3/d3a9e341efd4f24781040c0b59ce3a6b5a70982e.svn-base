package application.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import hissso.client.service.CounterScheduler;


public class VisitCounterListner implements ServletContextListener {
	
	

	//private static int timeInHrForComplaintClose;
	
	public void contextInitialized(ServletContextEvent objContextEvent)
	{
		//System.out.println("starting maillistner");
		
		CounterScheduler.updateTable();
			
			
	}

	public void contextDestroyed(ServletContextEvent objContextEvent)
	{
			 
	}

}
