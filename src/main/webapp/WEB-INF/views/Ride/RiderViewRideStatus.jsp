<%@ page import="service.ride.IRideService" %>
<%@ page import="service.ride.RideServiceImpl" %>
<%@ page import="model.Ride" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: sathnindu
  Date: 2023-10-12
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<p>Ride request id: <%= request.getAttribute("ride_id") %></p>--%>

<script>
    alert("Ride requested. \nRide request id: <%= request.getAttribute("ride_id") %>");
    window.location.href = "./RiderRideStatus?id=<%= request.getAttribute("ride_id") %>";
</script>

</body>
</html>
