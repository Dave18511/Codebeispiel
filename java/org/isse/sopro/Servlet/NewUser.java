package org.isse.sopro.Servlet;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.isse.sopro.bo.MAIL.EmailSever;
import org.isse.sopro.bo.UserEntity;
import org.isse.sopro.bo.UserManager;

import static org.isse.sopro.bo.RandomPasswords.randomPassword;

@WebServlet("/NewUser")
public class NewUser extends HttpServlet {


    /**
     * Adds a new UserEntity to the Application
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String mail = request.getParameter("mail");
        String name = request.getParameter("name");
        String organization = request.getParameter("organisation");
        String admin = request.getParameter("admin");
        String pwd = randomPassword();
        // checkbox only sends null for false and on for true..
        if (admin != null && admin.equals("on")) {
            admin = "true";
        }
        UserEntity u = new UserEntity(name, mail, pwd, organization, Boolean.valueOf(admin));
        UserManager.instance().linkUser(u);
        EmailSever.sendPassword(mail, pwd);
        response.sendRedirect("Users");
    }

    /**
     * Sends the UserEntity to the UserForm.jsp to add an UserEntity, if he's not authorized he's send to the Profile
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/UserForm.jsp").forward(request, response);
    }
}
