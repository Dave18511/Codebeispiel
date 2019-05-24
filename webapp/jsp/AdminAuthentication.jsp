<%--
  Created by IntelliJ IDEA.
  User: davidscherle
  Date: 2019-05-20
  Time: 17:25
  To change this template use File | Settings | File Templates.


  TODO change this to an Filter like LoginFilter
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    boolean admin = (boolean) request.getSession().getAttribute("admin");
    if (!admin) {
        response.sendRedirect("Profile");
    }
%>
</body>
</html>
