<%@ page import="service.ride.IRideService" %>
<%@ page import="service.ride.RideServiceImpl" %>
<%@ page import="model.Ride" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: sathnindu
  Date: 2023-10-14
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="MobileOptimized" content="320">
    <meta name="viewport" content="initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Ride Status | GoFlow</title>
    <link rel="stylesheet" href="./public/css/styles.css">
    <link rel="icon" type="image/x-icon" href="./public/images/GoFlow-Logo.png">
</head>
<body>

<%
    if (!session.getAttribute("role").equals("Rider")) {
        response.sendRedirect("./Login");
        return;
    }
%>

<jsp:include page="/WEB-INF/views/Common/Header.jsp"></jsp:include>

<%
    IRideService iRideService = new RideServiceImpl();
    Ride ride = iRideService.getRideByID((Integer) request.getAttribute("ride_id"));
%>

<div style="width: 100%; height: calc(100% - 60px); overflow: hidden;" class="con-mid">
    <div class="status-block-animated scale-animation"></div>
    <div class="status-block">

        <% if (Objects.equals(ride.getStatus(), "wait_driver")) {%>

        <h1>Finding a driver...</h1>
        <button class="btn" onclick="window.location.href = './DeleteRide?id=<%= ride.getRideId() %>&source=cancel'">
            Cancel
        </button>

        <%} else if (Objects.equals(ride.getStatus(), "wait_pickup")) {%>

        <h1>Your driver is arriving...</h1>

        <%} else if (Objects.equals(ride.getStatus(), "active")) {%>

        <h1>Enjoy your ride!</h1>

        <%} else if (Objects.equals(ride.getStatus(), "completed")) {
        session.removeAttribute("ride_id");
        %>

        <h1>Your payment is: LKR <%=ride.getFare()%>
        </h1>
        <button class="btn" onclick="window.location.href='AddRide?type=start'">Back</button>

        <%} else {%>
        <h1>Something went wrong!</h1>
        <%}%>

    </div>
</div>

</body>
</html>
