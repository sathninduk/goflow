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
    <title>Title</title>
</head>
<body>

<% IRideService iRideService = new RideServiceImpl();
    Ride ride = iRideService.getRideByID((Integer) request.getAttribute("ride_id"));%>

<p>Status: <%= ride.getStatus() %>
</p>
<% if (Objects.equals(ride.getStatus(), "wait_driver")) {%>

<h1>Finding a driver...</h1>
<button onclick="window.location.href = './DeleteRide?id=<%= ride.getRideId() %>'">Cancel</button>

<%} else if (Objects.equals(ride.getStatus(), "wait_pickup")) {%>

<h1>Your driver is arriving...</h1>

<%} else if (Objects.equals(ride.getStatus(), "active")) {%>

<h1>Enjoy your ride!</h1>

<%} else if (Objects.equals(ride.getStatus(), "completed")) {%>

<h1>Your payment is: LKR <%=ride.getFare()%>
</h1>
<button onclick="window.location.href='AddRide?type=start'">Back</button>

<%} else {%>
<h1>Something went wrong!</h1>
<%}%>

</body>
</html>
