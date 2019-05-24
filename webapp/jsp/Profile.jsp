<%--
  Created by IntelliJ IDEA.
  User: davidscherle
  Date: 2019-05-12
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%--
    Displays UserEntity information and offers option to logout
--%>
<%@ page import="org.isse.sopro.bo.UserEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
    <title>Profile</title>
</head>
<body>
<%@include file="Navbar.jsp" %>
<%
    UserEntity u = (UserEntity) request.getAttribute("user");
%>
<div class="container-fluid">
    <div class="row">
        <div class="col p-5 text-center text-primary">
            <h1>Profile</h1>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-3 p-2 text-left text-primary">
            <h3>Name:</h3>
        </div>
        <div class="col-3 p-2 text-left text-secondary">
            <h3><%
                out.print(u.getName());
            %></h3>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-3 p-2 text-left text-primary">
            <h3>Email:</h3>
        </div>
        <div class="col-3 p-2 text-left text-secondary">
            <h3><%
                out.print(u.getMail());
            %></h3>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-3 p-2 text-left text-primary">
            <h3>Organisation:</h3>
        </div>
        <div class="col-3 p-2 text-left text-secondary">
            <h3><%
                out.print(u.getOrganisation());
            %></h3>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-2 text-right p-2">
            <a href="PasswordConfig" class="btn btn-primary">New Password</a>
        </div>
        <div class="col-2 text-left p-2">
            <a href="UserEdit" class="btn btn-primary">Edit Information</a>
        </div>
    </div>
</div>
</body>
</html>
