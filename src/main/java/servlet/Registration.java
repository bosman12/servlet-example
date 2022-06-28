package servlet;

import dataSource.DataSource;
import entity.User;
import service.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registration extends HttpServlet {

    private static final String USER_REGISTRATION_SUCCESS = "Пользователь успешно зарегистрирован !";
    int id=0;

    private RegistrationService userRegistration;
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        final Object userRegistration = getServletContext().getAttribute("userRegistration");
        this.userRegistration = (RegistrationService) userRegistration;

        this.dataSource = (DataSource) getServletContext().getAttribute("dataSource");


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/HTML");

        String username = req.getParameter("username");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");

        id++;
        User newUser = userRegistration.registration(id, username, name, surname, password, age, email);
        dataSource.addUsersList(newUser);

        resp.getWriter().write(USER_REGISTRATION_SUCCESS);




    }
}
