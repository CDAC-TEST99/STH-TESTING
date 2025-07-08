package thirdpartyservices.bharatkosh.service;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
 
public class BKPayTrackSchedulerContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
      //  System.out.println("BKPayTrackScheduler CARDMGMT application started. Initializing scheduler...");
        BKPayTrackScheduler.startScheduler();  
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
      //  System.out.println("BKPayTrackScheduler Web application stopped. Shutting down scheduler...");
    }
}
