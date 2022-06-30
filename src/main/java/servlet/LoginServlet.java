package servlet;

import service.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private AuthenticationService autentificationService;

    @Override
    public void init() throws ServletException {
        this.autentificationService = (AuthenticationService)getServletContext().
                getAttribute("autentificationService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        if (autentificationService.isAuthenticate(userName,password)){
            final HttpSession userSession = req.getSession();
            userSession.setAttribute("userName", userName);
            resp.sendRedirect("/main");
        }
        else {
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/HTML");
            resp.getWriter().write("Неверный логин пароль");
        }


    }
}
