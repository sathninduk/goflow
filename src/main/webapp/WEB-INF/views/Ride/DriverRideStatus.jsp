<%@ page import="service.ride.IRideService" %>
<%@ page import="service.ride.RideServiceImpl" %>
<%@ page import="model.Ride" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: sathnindu
  Date: 2023-10-14
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    IRideService iRideService = new RideServiceImpl();
    Ride ride = iRideService.getRideByID(Integer.parseInt(request.getParameter("id")));
%>

<p>Ride id: <%= ride.getRideId() %></p>

<% if(Objects.equals(ride.getStatus(), "wait_pickup")) { %>

<h1>Heading to the pickup location</h1>
<button onclick="window.location.href = './DriverUpdateRideStatus?id=<%= ride.getRideId() %>&status=active'">Pickup</button>

<% } else if(Objects.equals(ride.getStatus(), "active")) { %>

<h1>Heading to the destination</h1>
<button onclick="window.location.href = './DriverUpdateRideStatus?id=<%= ride.getRideId() %>&status=completed'">Dropoff</button>

<% } else if(Objects.equals(ride.getStatus(), "completed")) { %>

<h1>Ride completed</h1>
<h3>Collect payment: LKR <%= ride.getFare() %></h3>
<button onclick="window.location.href = './DriverRinging'">End</button>

<% } else { %>
<script>window.location.href = "./DriverRinging"</script>
<% } %>

</body>
</html>