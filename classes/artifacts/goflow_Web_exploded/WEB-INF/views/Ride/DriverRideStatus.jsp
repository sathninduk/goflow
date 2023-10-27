<%@ page import="service.ride.IRideService" %>
<%@ page import="service.ride.RideServiceImpl" %>
<%@ page import="model.Ride" %>
<%@ page import="java.util.Objects" %>
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
    if (!session.getAttribute("role").equals("Driver")) {
        response.sendRedirect("./Login");
        return;
    }
%>

<jsp:include page="/WEB-INF/views/Common/Header.jsp"></jsp:include>

<%

    IRideService iRideService = new RideServiceImpl();
    boolean rideExists = iRideService.checkRideExists(Integer.parseInt(request.getParameter("id")));

    if (!rideExists) {
        response.sendRedirect("./DriverRinging");
        return;
    }

    Ride ride = iRideService.getRideByID(Integer.parseInt(request.getParameter("id")));
%>

<div style="width: 100%; height: calc(100% - 60px);" class="con-mid">
    <div class="status-block-animated scale-animation"></div>
    <div class="status-block">

        <% if (Objects.equals(ride.getStatus(), "wait_pickup")) { %>

        <h1>Heading to the pickup location</h1>
        <button class="btn" onclick="window.location.href = './DriverUpdateRideStatus?id=<%= ride.getRideId() %>&status=active'">
            Pickup
        </button>

        <% } else if (Objects.equals(ride.getStatus(), "active")) { %>

        <h1>Heading to the destination</h1>
        <button class="btn" onclick="window.location.href = './DriverUpdateRideStatus?id=<%= ride.getRideId() %>&status=completed'">
            Dropoff
        </button>

        <% } else if (Objects.equals(ride.getStatus(), "completed")) { %>

        <h1>Ride completed</h1>
        <h3>Collect payment: LKR <%= ride.getFare() %>
        </h3>
        <button class="btn" onclick="window.location.href = './DriverRinging'">End</button>

        <% } else { %>
        <script>window.location.href = "./DriverRinging"</script>
        <% } %>
    </div>
</div>

</body>
</html>
