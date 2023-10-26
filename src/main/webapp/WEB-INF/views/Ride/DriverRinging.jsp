<%@ page import="service.ride.IRideService" %>
<%@ page import="service.ride.RideServiceImpl" %>
<%@ page import="model.Ride" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.VehicleType" %>
<%@ page import="service.vehicleType.IVehicleTypeService" %>
<%@ page import="service.vehicleType.IVehicleTypeServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: sathnindu
  Date: 2023-10-13
  Time: 09:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="MobileOptimized" content="320">
    <meta name="viewport" content="initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Rides Rining | GoFlow</title>
    <link rel="stylesheet" href="./public/css/styles.css">
    <link rel="icon" type="image/x-icon" href="./public/images/GoFlow-Logo.png">
</head>
<body class="gray-bg">

<%
    if (!session.getAttribute("role").equals("Driver")) {
        response.sendRedirect("./Login");
        return;
    }
%>

<jsp:include page="/WEB-INF/views/Common/Header.jsp"></jsp:include>

<%-- <p><%= r.getRideId() %></p> --%>

<div class="con-mid" style="width: 100%;">
    <div class="container" style="margin: 60px 0;">
        <h1 style="text-align: left; width: 100%; margin: 0 0 30px;">Ride Requests</h1>
        <div class="blocks blocks-heading">
            <p>Pickup</p>
            <p>Destination</p>
            <p>Distance</p>
            <p>Fare</p>
            <p>Action</p>
        </div>
        <%
            IVehicleTypeService iVehicleTypeService = new IVehicleTypeServiceImpl();
            VehicleType vehicleType = iVehicleTypeService.getVehicleTypeByID(Integer.parseInt(session.getAttribute("vehicleType").toString()));

            IRideService iRideService = new RideServiceImpl();
            ArrayList<Ride> ride = iRideService.getRidesByStatusAndVehicle("wait_driver", vehicleType);

            if (ride.size() == 0) {
        %>
        <div style="text-align: center">
            <p>No rides available</p>
        </div>
        <%
            }

            for (Ride r : ride) {
        %>
        <div class="blocks">
            <p onclick="openMap(<%= r.getStart_latitude() %>,<%= r.getStart_longitude() %>)"
               class="map-btn"><%= r.getStart_latitude() %>, <%= r.getStart_longitude() %> <span>📍</span></p>
            <p onclick="openMap(<%= r.getEnd_latitude() %>,<%= r.getEnd_longitude() %>)"
               class="map-btn"><%= r.getEnd_latitude() %>, <%= r.getEnd_longitude() %> <span>📍</span></p>
            <h4><%= r.getDistance() %>km</h4>
            <h3>LKR <%= r.getFare() %>
            </h3>
            <form action="./DriverUpdateRideStatus?status=wait_pickup" method="post" style="margin: 0">
                <input type="hidden" name="id" value="<%= r.getRideId() %>">
                <button type="submit" class="btn">Accept</button>
            </form>
        </div>
        <%}%>
    </div>
</div>

<script>
    function openMap(lat, lon) {
        window.open("https://www.google.com/maps/@" + lat + "," + lon + ",17.45z", "_blank");
    }
</script>

</body>
</html>
