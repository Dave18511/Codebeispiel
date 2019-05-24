package org.isse.sopro.Servlet;

import org.isse.sopro.bo.UserEntity;
import org.isse.sopro.bo.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserEdit")
public class UserEdit extends HttpServlet {

    /**
     *
     * Edits the User information
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mail = request.getParameter("mail");
        String name = request.getParameter("name");
        String organisation = request.getParameter("organisation");
        UserEntity u = UserManager.instance().getUserByMail((String) request.getSession().getAttribute("mail"));
        //TODO should be done with merge in set Methods instead of deleting and linking again..
        UserManager.instance().deleteUser(u);
        u.setMail(mail);
        u.setName(name);
        u.setOrganisation(organisation);
        UserManager.instance().linkUser(u);
        response.sendRedirect("Profile");
    }

    /**
     *
     * Forwards the User to UserEdit.jsp and gives jsp attribute to show
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user", UserManager.instance().getUserByMail((String) request.getSession().getAttribute("mail")));
        request.getRequestDispatcher("/jsp/UserEdit.jsp").forward(request, response);
    }
}
