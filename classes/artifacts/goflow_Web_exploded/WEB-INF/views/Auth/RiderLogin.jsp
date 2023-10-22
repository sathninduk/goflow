<%--
  Created by IntelliJ IDEA.
  User: sathnindu
  Date: 2023-10-03
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="MobileOptimized" content="320">
    <meta name="viewport" content="initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Rider Login | GoFlow</title>
    <link rel="stylesheet" href="./public/css/styles.css">
    <link rel="icon" type="image/x-icon" href="./public/images/GoFlow-Logo.png">
</head>
<body style="overflow-y: hidden">

<%
    if (session.getAttribute("id") != null) {
        response.sendRedirect("./Login");
        return;
    }
%>

<jsp:include page="/WEB-INF/views/Common/Header.jsp"></jsp:include>

<div class="login-con con-mid">
    <div class="login-box">
        <div>
            <button class="small-btn" onclick="window.location.href = './Login'">Back</button>
            <h3>Rider Login</h3>
        </div>
        <form action="./RiderLogin" method="post" onsubmit="return formValidation()">
            <label>
                <input id="email" name="email" placeholder="Email">
                <span class="error-message" id="error-email"></span>
            </label>
            <label>
                <input type="password" id="password" name="password" placeholder="Password">
                <span class="error-message" id="error-pw"></span>
            </label>
            <input class="login-btn" type="submit" value="Login">
        </form>
        <p class="legal-footer">
            © <span id="year"></span> GoFlow. All rights reserved.
        </p>
    </div>
</div>

<script src="./public/js/validation/loginValidation.js"></script>
<script src="./public/js/scripts.js"></script>

</body>
</html>
