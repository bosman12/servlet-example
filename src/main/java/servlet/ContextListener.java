package servlet;

import dataSource.DataSource;
import service.RegistrationService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 Загружается до создания всех сервлетов.
 */

@WebListener
public class ContextListener implements ServletContextListener {
    private RegistrationService userRegistration;
    private DataSource dataSource;


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        final ServletContext servletContext =
                servletContextEvent.getServletContext();



        userRegistration = new RegistrationService();
        dataSource = new DataSource();

        servletContext.setAttribute("userRegistration",userRegistration );
        servletContext.setAttribute("dataSource",dataSource);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
