package thirdpartyservices.bhavishya.scheduler;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import thirdpartyservices.bhavishya.scheduler.CustomScheduler;
 
public class SchedulerContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
       // System.out.println("CARDMGMT application started. Initializing scheduler...");
        CustomScheduler.startScheduler();  
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
      //  System.out.println("Web application stopped. Shutting down scheduler...");
    }
}
