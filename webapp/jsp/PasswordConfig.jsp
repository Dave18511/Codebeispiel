<%--
  Created by IntelliJ IDEA.
  User: davidscherle
  Date: 2019-05-15
  Time: 10:50
  To change this template use File | Settings | File Templates.


  Form for changing the Password

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
    <title>Set your Password</title>
</head>
<body>
<%@include file="Navbar.jsp" %>
<form class="form-group" id="SetPassword" action="PasswordConfig" method="post">
    <div class="container-fluid">
        <div class="row">
            <div class="col p-5 text-primary text-center">
                <h1>Set new Password</h1>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-3 text-right text-primary p-2">
                <h3>New Password:</h3>
            </div>
            <div class="col-3">
                <input type="text" id="password" name="password" class="form-control" required minlength="8">
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-1">
                <a href="Profile" class="btn btn-danger">Cancel</a>
            </div>
            <div class="col-1">
                <button class="btn btn-primary" type="submit">Apply</button>
            </div>
        </div>
    </div>
</form>
</body>
</html>
