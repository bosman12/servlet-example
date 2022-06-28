package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        String loginURL = request.getContextPath() + "/login";
        String registrationURL = request.getContextPath() + "/registration";

        boolean loggedIn = session != null && session.getAttribute("userName") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURL)
                || request.getRequestURI().equals(loginURL + ".jsp");
        boolean registrationRequest = request.getRequestURI().equals(registrationURL)
                || request.getRequestURI().equals(registrationURL + ".jsp");

        if(loggedIn || loginRequest || registrationRequest) {filterChain.doFilter(req, res);
        } else {
            response.sendRedirect("/login");
        }


    }

    @Override
    public void destroy() {

    }
}
