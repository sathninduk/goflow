<%@ page import="service.ride.IRideService" %>
<%@ page import="service.ride.RideServiceImpl" %>
<%@ page import="model.Ride" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: sathnindu
  Date: 2023-10-13
  Time: 09:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ringing</title>
</head>
<body>

<%
    IRideService iRideService = new RideServiceImpl();
    ArrayList<Ride> ride = iRideService.getRidesByStatus("wait_driver");

    for (Ride r : ride) {
%>

    <p><%= r.getRideId() %></p>

<%}%>

</body>
</html>
