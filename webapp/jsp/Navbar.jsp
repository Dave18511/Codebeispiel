<%--
  Created by IntelliJ IDEA.
  User: davidscherle
  Date: 2019-05-20
  Time: 14:33
  To change this template use File | Settings | File Templates.

  Basic Navbar of the Homepage
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark bg-primary">
    <img src="../Images/makandra.svg" class="navbar-brand">
    <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarmenu">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarmenu">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a href="Profile" class="nav-link">Profile</a>
            </li>
            <li class="nav-item">
                <a href="Users" class="nav-link">Users</a>
            </li>
            <li class="nav-item">
                <a href="NewUser" class="nav-link">Userregistration</a>
            </li>
            <li class="nav-item">
                <a href="#" class="nav-link">Reports</a>
            </li>

        </ul>
    </div>
    <div class="collapse navbar-collapse" id="navbarmenu2">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a href="Logout" class="nav-link">Logout</a>
            </li>
        </ul>
    </div>
</nav>
</body>
</html>
