package org.isse.sopro.Servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    public void destroy() {
    }

    /**
     *
     * Makes sure every User that wants to access a page other than the login or index is loged in
     *
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession ses = request.getSession(false);
        if (!request.getRequestURI().equals("/osca") && !request.getRequestURI().equals("/osca/login")) {
            if (ses == null) {
                request.getRequestDispatcher("login").forward(request, response);
            } else {
                Object mail = ses.getAttribute("mail");
                if (mail == null) {
                    request.getRequestDispatcher("login").forward(request, response);
                }
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
