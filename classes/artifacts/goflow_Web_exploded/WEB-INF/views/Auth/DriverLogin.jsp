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
    <title>GoFlow | Driver Login</title>
    <link rel="stylesheet" href="./public/css/styles.css">
    <link rel="icon" type="image/x-icon" href="./public/images/GoFlow-Logo.png">
</head>
<body style="overflow-y: hidden">

<jsp:include page="/WEB-INF/views/Common/Header.jsp"></jsp:include>

<div class="login-con con-mid">
    <div class="login-box">
        <div>
            <button class="small-btn" onclick="window.location.href = './Login'">Back</button>
            <h3>Driver Login</h3>
        </div>
        <form action="./DriverLogin" method="post">
            <label>
                <input type="email" name="email" placeholder="Email">
            </label>
            <label>
                <input type="password" name="password" placeholder="Password">
            </label>
            <input class="login-btn" type="submit" value="Login">
        </form>
        <p class="legal-footer">
            © <span id="year"></span> GoFlow. All rights reserved.
        </p>
    </div>
</div>

<script src="./public/js/scripts.js"></script>
</body>
</html>
