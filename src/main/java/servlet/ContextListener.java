package servlet;

import dataSource.UserDaoImpl;
import service.AuthenticationService;
import service.RegistrationService;
import validation.UserValidation;

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
    private UserDaoImpl dataSource;
    private AuthenticationService autentificationService;
    private UserValidation userValidation;


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        dataSource = new UserDaoImpl();
        autentificationService=new AuthenticationService(dataSource);
        userValidation = new UserValidation(dataSource);
        userRegistration = new RegistrationService();


        servletContext.setAttribute("autentificationService",autentificationService);
        servletContext.setAttribute("userRegistration",userRegistration );
        servletContext.setAttribute("dataSource",dataSource);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
