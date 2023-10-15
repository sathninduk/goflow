<%@ page import="service.ride.IRideService" %>
<%@ page import="service.ride.RideServiceImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Ride" %><%--
  Created by IntelliJ IDEA.
  User: sathnindu
  Date: 2023-10-14
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body class="gray-bg">

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
            ArrayList<Ride> rides = iRideService.getRides();

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
            <h3>LKR <%= r.getFare() %></h3>
            <p class="map-btn"><%= r.getStatus() %></p>
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