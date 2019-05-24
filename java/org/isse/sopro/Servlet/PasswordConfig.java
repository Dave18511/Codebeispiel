package org.isse.sopro.Servlet;

import org.isse.sopro.bo.SessionFactoryManager;
import org.isse.sopro.bo.UserEntity;
import org.isse.sopro.bo.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PasswordConfig")
public class PasswordConfig extends HttpServlet {

    /**
     *
     * Updates the password of the User
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String mail = (String) request.getSession().getAttribute("mail");
        UserEntity u = UserManager.instance().getUserByMail(mail);
        u.setUnhashedPassword(password);
        SessionFactoryManager.instance().merge(u);
        response.sendRedirect("Profile");
    }

    /**
     *
     * just shows the Passwordconfig jsp
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/PasswordConfig.jsp").forward(request, response);
    }
}
