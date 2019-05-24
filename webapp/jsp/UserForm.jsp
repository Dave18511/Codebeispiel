<%--
  Created by IntelliJ IDEA.
  User: davidscherle
  Date: 2019-05-07
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>

<%--
    if the user is autherized the UserEntity can fillout the form to add an new UserEntity to the Application
--%>
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
    <title>Title</title>
</head>
<body>
<%@ include file="AdminAuthentication.jsp"%>
<%@include file="Navbar.jsp" %>
<form class="form-horizontal" id="NewUser" method="POST" action="NewUser">
    <div class="container-fluid">
        <div class="row">
            <div class="col text-center text-primary p-5">
                <h1>New User Registration</h1>
            </div>
        </div>
        <div class="row justify-content-center text-primary">
            <div class="col-2 text-left p-2">
                <h3>Name:</h3>
            </div>
            <div class="col-3">
                <input type="text" class="form-control" id="name" name="name" required minlength="3">
            </div>
        </div>
        <div class="row justify-content-center text-primary">
            <div class="col-2 text-left p-2">
                <h3>Email:</h3>
            </div>
            <div class="col-3">
                <input type="text" class="form-control" id="email" name="mail" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$">
            </div>
        </div>
        <div class="row justify-content-center text-primary">
            <div class="col-2 text-left p-2">
                <h3>Organisation:</h3>
            </div>
            <div class="col-3">
                <input type="text" class="form-control" id="organisation" name="organisation" required minlength="3">
            </div>
        </div>
        <div class="row justify-content-center text-primary">
            <div class="col-2 text-left p-2">
                <h3>Admin:</h3>
            </div>
            <div class="col-3">
                <input type="checkbox" class="form-control" id="admin" name="admin">
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-1">
                <a href="Users" class="btn btn-danger">Cancel</a>
            </div>
            <div class="col-1">
                <button type="submit" class="btn btn-success">Submit</button>
            </div>
        </div>
    </div>
</form>
</body>
</html>
