<%--
  Created by IntelliJ IDEA.
  User: davidscherle
  Date: 2019-05-02
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>

<%--
    Usermanagment if the user is admin else he is send to Profile
--%>
<%@ page import="org.isse.sopro.bo.UserEntity" %>
<%@ page import="java.util.Collection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <title>User Overview</title>
</head>
<body>
<%@include file="AdminAuthentication.jsp"%>
<%@include file="Navbar.jsp" %>
<div class="container-fluid">
    <div class="row">
        <div class="col text-center text-primary p-5">
            <h1>Usermanagement</h1>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-10 ">
            <table class="table table-striped table-hover">
                <tr class="text-primary">
                    <th>Name</th>
                    <th>Mail</th>
                    <th>Organisation</th>
                    <th>Admin</th>
                </tr>
                <title>CurrentUsers:</title>
                <%
                    Collection<UserEntity> users = (Collection<UserEntity>) request.getAttribute("users");
                    if (users != null) {
                        for (UserEntity u : users) {
                            out.println("<tr>");
                            out.println("<td>" + u.getName() + "</td>");
                            out.println("<td>" + u.getMail() + "</dt>");
                            out.println("<td>" + u.getOrganisation() + "</dt>");
                            out.println("<td>" + u.isAdmin() + "</dt>");
                            out.println("</tr>");
                        }

                    }
                %>
            </table>
        </div>
    </div>
</div>
</body>
</html>
