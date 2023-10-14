<%@ page import="service.ride.IRideService" %>
<%@ page import="service.ride.RideServiceImpl" %>
<%@ page import="model.Ride" %><%--
  Created by IntelliJ IDEA.
  User: sathnindu
  Date: 2023-10-13
  Time: 15:47
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
    boolean rideExists = iRideService.checkRideExists(Integer.parseInt(request.getParameter("id")));

    if (rideExists) {
        Ride ride = iRideService.getRideByID(Integer.parseInt(request.getParameter("id")));
%>

<p>Redirecting...</p>

<script>
    alert("Ride accepted");
    window.location.href = "./DriverRideStatus?id=<%=ride.getRideId()%>";
</script>

<%} else {%>
<script>
    alert("Ride cancelled");
    window.location.href = "./DriverRinging";
</script>
<%}%>


</body>
</html>
