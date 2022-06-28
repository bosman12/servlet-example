package servlet;

import dataSource.DataSource;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class GetMainPage extends HttpServlet {
    private Map<Integer, User> users;
    private DataSource dataSource;

    @Override
    public void init(){
        this.dataSource = (DataSource) getServletContext().getAttribute("dataSource");
        users=new HashMap();
        users = dataSource.getUserList();
        System.out.println(users);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("users", users.values());
        req.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(req, resp);
    }
}
