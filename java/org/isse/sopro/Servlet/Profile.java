package org.isse.sopro.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.isse.sopro.bo.UserManager;

@WebServlet("/Profile")
public class Profile extends HttpServlet {

  /**
   *
   * Logs the UserEntity out and sends him to the Loginpage
   *
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   */
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    request.getSession().invalidate();
    response.sendRedirect("login");
  }

  /**
   *
   * Forwards the UserEntity to Profile.jsp if he's loged in else to the Loginpage
   *
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   */
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    String mail = (String) session.getAttribute("mail");
    request.setAttribute("user", UserManager.instance().getUserByMail(mail));
    request.getRequestDispatcher("/jsp/Profile.jsp").forward(request, response);
  }
}
