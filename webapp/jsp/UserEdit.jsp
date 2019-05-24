<%@ page import="org.isse.sopro.bo.UserEntity" %><%--
  Created by IntelliJ IDEA.
  User: davidscherle
  Date: 2019-05-20
  Time: 12:35
  To change this template use File | Settings | File Templates.

  Form for changing User information
--%>
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
    <title>Edit User</title>
</head>
<body>
<%@include file="Navbar.jsp" %>
<form action="UserEdit" method="POST" class="form-group">
    <div class="container-fluid centered">
        <%
            UserEntity u = (UserEntity) request.getAttribute("user");
        %>
        <div class="row justify-content-center">
            <div class="col text-primary p-5 text-center">
                <h1>Edit User Informationen</h1>
            </div>
        </div>
        <div class="row justify-content-center">
            <label for="mail" class="col-2 p-2 text-primary text-left"><h3>Email:</h3></label>
            <div class="col-3 p-2">
                <input class="form-control" id="mail" name="mail" value="<% out.print(u.getMail()); %>" required
                       pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$">
            </div>
        </div>
        <div class="row justify-content-center">
            <label for="name" class="col-2 p-2 text-primary text-left"><h3>Name:</h3></label>
            <div class="col-3 p-2">
                <input class="form-control" id="name" name="name" value="<% out.print(u.getName()); %>" required
                       minlength="3">
            </div>
        </div>
        <div class="row justify-content-center">
            <label for="organisation" class="col-2 p-2 text-primary text-left"><h3>Organisation</h3></label>
            <div class="col-3 p-2">
                <input class="form-control" id="organisation" name="organisation"
                       value="<% out.print(u.getOrganisation()); %>" required minlength="3">
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-1">
                <a href="Profile" class="btn btn-danger ">Cancel</a>
            </div>
            <div class="col-1">
                <button class="btn btn-primary" type="reset">Reset</button>
            </div>
            <div class="col-1">
                <button class="btn btn-success" type="submit">Submit</button>
            </div>
        </div>
    </div>
</form>
</body>
</html>
