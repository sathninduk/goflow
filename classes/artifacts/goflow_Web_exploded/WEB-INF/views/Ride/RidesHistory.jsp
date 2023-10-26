<%@ page import="service.ride.IRideService" %>
<%@ page import="service.ride.RideServiceImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Ride" %>
<%@ page import="model.Rider" %>
<%@ page import="service.rider.RiderServiceImpl" %>
<%@ page import="service.rider.IRiderService" %><%--
  Created by IntelliJ IDEA.
  User: sathnindu
  Date: 2023-10-14
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="MobileOptimized" content="320">
    <meta name="viewport" content="initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Rides History | GoFlow</title>
    <link rel="stylesheet" href="./public/css/styles.css">
    <link rel="icon" type="image/x-icon" href="./public/images/GoFlow-Logo.png">
</head>
<body class="gray-bg">

<%
   if (!session.getAttribute("role").equals("Rider")) {
        response.sendRedirect("./Login");
       return;
    }
%>

<jsp:include page="/WEB-INF/views/Common/Header.jsp"></jsp:include>

<div class="con-mid" style="width: 100%;">
    <div class="container" style="margin: 60px 0;">
        <h1 style="text-align: left; width: 100%; margin: 0 0 30px;">Ride History</h1>
        <div class="blocks blocks-heading">
            <p>Date</p>
            <p>Pickup</p>
            <p>Destination</p>
            <p>Distance</p>
            <p>Fare</p>
            <p>Status</p>
            <p>Action</p>
        </div>

        <%
            IRideService iRideService = new RideServiceImpl();
            IRiderService iRiderService = new RiderServiceImpl();
            Rider para_rider = iRiderService.getRiderByID(Integer.parseInt(session.getAttribute("id").toString()));
            ArrayList<Ride> rides = iRideService.getRideByRider(para_rider);

            for (Ride r : rides) {
        %>

        <div class="blocks">
            <p>
                <%= r.getDate_time() %>
            </p>
            <p onclick="openMap(<%= r.getStart_latitude() %>,<%= r.getStart_longitude() %>)"
               class="map-btn"><%= r.getStart_latitude() %>, <%= r.getStart_longitude() %> <span>📍</span></p>
            <p onclick="openMap(<%= r.getEnd_latitude() %>,<%= r.getEnd_longitude() %>)"
               class="map-btn"><%= r.getEnd_latitude() %>, <%= r.getEnd_longitude() %> <span>📍</span></p>
            <h4><%= r.getDistance() %>km</h4>
            <h3>LKR <%= r.getFare() %>
            </h3>
            <p class="map-btn"><%= r.getStatus() %>
            </p>
            <form action="./DeleteRide" method="post" style="margin: 0">
                <input type="hidden" name="id" value="<%= r.getRideId() %>">
                <input type="hidden" name="source" value="history">
                <button type="submit" class="btn">Delete</button>
            </form>
        </div>

        <%}%>

    </div>
</div>


</body>
</html>
