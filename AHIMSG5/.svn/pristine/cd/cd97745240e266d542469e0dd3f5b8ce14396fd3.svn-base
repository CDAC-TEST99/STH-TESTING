/**********************************************************
 Project:	   AHIMS_G5	
 File:         HISApplicationContextListener.java
 Created:      Jan, 2014
 Last Changed: Mar, 2016
 Author:       Pragya Sharma

This code is copyright (c) 2014 C-DAC Noida.
***********************************************************/

package application.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import application.config.HISApplicationConfig;
import hisglobal.scheduler.AlertJobRunner;
import hisglobal.utility.HisUtil;
import hissso.config.HISSSOServerConfig;

public class HISApplicationContextListener implements ServletContextListener
{
	public void contextInitialized(ServletContextEvent objContextEvent)
	{
		ServletContext objContext = objContextEvent.getServletContext();
		
		// Application Initialization 
		new HISApplicationConfig().setApplictaionInitials(objContext);
		
		// SSO Server Initialization
		HISSSOServerConfig.initializeSSOServer(objContext);
		
	//	System.out.println("listener & sms email scheduler started");
		String email_job_schedular=HisUtil.getParameterFromHisPathXML("EMAIL_JOB_SCHEDULER");
		if(email_job_schedular==null || email_job_schedular.equals("ON") )
			AlertJobRunner.startScheduler();
		
		
	}

	public void contextDestroyed(ServletContextEvent objContextEvent)
	{
		// Nothing to do right now for HIS
		
		AlertJobRunner.stopScheduler();
	}
}
