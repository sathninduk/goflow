<%--
  Created by IntelliJ IDEA.
  User: sathnindu
  Date: 2023-10-03
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!--<link rel="stylesheet" href="./public/css/styles.css">-->
    <!--<link rel="icon" type="image/x-icon" href="./public/images/GoFlow-Logo.png">-->
</head>
<body>

<nav>
    <div class="nav-left-links">
        <a href="${pageContext.request.contextPath}/" class="nav-logo">GoFlow</a>
    </div>
    <div class="nav-right-links">
        <a href="${pageContext.request.contextPath}/Login">Login</a>
        <a href="${pageContext.request.contextPath}/RiderRegister">Register</a>
        <a href="${pageContext.request.contextPath}/Logout">Logout</a>
    </div>
</nav>

</body>
</html>
