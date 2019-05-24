package org.isse.sopro.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.isse.sopro.bo.UserManager;

@WebServlet("/Users")
public class Users extends HttpServlet {

  /**
   *
   * Forwards to Users.jsp if the user is loged in else sends him to the Loginpage
   *
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession ses = request.getSession();
    Object admin =  ses.getAttribute("admin");
    if (admin != null) {
      if ((boolean) admin) {
        request.setAttribute("users", UserManager.instance().getUsers());
        request.getRequestDispatcher("jsp/Users.jsp").forward(request, response);
      } else {
        response.sendRedirect("/Profile");
      }
    } else {
      response.sendRedirect("/Profile");
    }
  }


  /**
   *
   * not needed
   *
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  }
}
