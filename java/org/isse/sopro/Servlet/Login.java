package org.isse.sopro.Servlet;

import com.lambdaworks.crypto.SCryptUtil;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.isse.sopro.bo.UserEntity;
import org.isse.sopro.bo.UserManager;

@WebServlet("/login")
public class Login extends HttpServlet {

    private UserManager users;

    /**
     * Authenticates the UserEntity and adds mail and admin to session to authenticate the user on other
     * pages. If authentication fails the user is asked to reenter his mail and password
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String mail = request.getParameter("email");
        String password = request.getParameter("password");
        UserEntity user = UserManager.instance().getUserByMail(mail);
        if (user != null) {
            if (SCryptUtil.check(password, user.getPassword())) {
                HttpSession ses = request.getSession();
                ses.setAttribute("mail", user.getMail());
                ses.setAttribute("admin", user.isAdmin());
                //PRG pattern for better experience
                response.sendRedirect("Users");
                return;
            }
        }
        // TODO jsp implementation of failed login, ajax..
        PrintWriter out = response.getWriter();
        out.println("<html> <head> </head> <body> <p>");
        out.println("Invalid Username or Password!<br>");
        out.println("Please try again or Contact an admin!</p> </body> </html>");
        request.getRequestDispatcher("index.jsp").include(request, response);
    }

    /**
     * just forwards the user to the Loginpage
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
