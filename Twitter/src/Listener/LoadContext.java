package Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.Twitter;

/**
 * Application Lifecycle Listener implementation class LoadContext
 *
 */
@WebListener
public class LoadContext implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public LoadContext() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event) {
    	Twitter twitter =  Twitter.getInstance();
    	ServletContext ctx = event.getServletContext();
    	ctx.setAttribute("Twitter", twitter);
    	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
