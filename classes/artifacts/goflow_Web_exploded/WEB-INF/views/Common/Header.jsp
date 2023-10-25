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
        <% if (session.getAttribute("id") != null) { %>

        <% if (session.getAttribute("role").equals("Rider")) { %>
        <% if (session.getAttribute("ride_id") != null) { %>
        <a href="${pageContext.request.contextPath}/RiderRideStatus?id=<%=session.getAttribute("ride_id")%>">Current
            Ride</a>
        <% } else { %>
        <a href="${pageContext.request.contextPath}/AddRide?type=start">New Ride</a>
        <% } %>
        <a href="${pageContext.request.contextPath}/RidesHistory">Rides History</a>
        <a> | </a>
        <% } %>

        <a href="${pageContext.request.contextPath}/Login"><%= session.getAttribute("username") %>
        </a>
        <a href="${pageContext.request.contextPath}/Logout">Logout</a>
        <% } else { %>
        <a style="color: #000; background-color: #fff; border-radius: 8px; padding: 4px 10px;"
           href="${pageContext.request.contextPath}/AdminLogin">Admin Login</a>
        <a> | </a>
        <a href="${pageContext.request.contextPath}/Login">Login</a>
        <a href="${pageContext.request.contextPath}/Register">Register</a>
        <% } %>
    </div>
</nav>

</body>
</html>
