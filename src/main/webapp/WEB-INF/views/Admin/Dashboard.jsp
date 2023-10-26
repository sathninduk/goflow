<%--
  Created by IntelliJ IDEA.
  User: sathnindu
  Date: 2023-10-18
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="MobileOptimized" content="320">
    <meta name="viewport" content="initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Admin Dashboard | GoFlow</title>
    <link rel="stylesheet" href="./public/css/styles.css">
    <link rel="icon" type="image/x-icon" href="./public/images/GoFlow-Logo.png">
</head>
<body class="gray-bg">

<%
    if (!session.getAttribute("role").equals("Admin")) {
        response.sendRedirect("./Login");
        return;
    }
%>

<jsp:include page="/WEB-INF/views/Common/Header.jsp"></jsp:include>

<div class="admin-block-panel">
    <div style="margin-left: 15px">
        <h1>Admin Dashboard</h1>
    </div>
    <div class="admin-block" onclick="window.location.href = './ListRider'">
        <div class="admin-block-icon"><span>&#128587;</span></div>
        Rider Management
    </div>
    <div class="admin-block" onclick="window.location.href = './ListDriver'">
        <div class="admin-block-icon"><span>&#129333;</span></div>
        Driver Management
    </div>
    <div class="admin-block" onclick="window.location.href = './ListVehicleType'">
        <div class="admin-block-icon"><span>&#128663;</span></div>
        Vehicle Types Management
    </div>
</div>

</body>
</html>
