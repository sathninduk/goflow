<%@ page import="java.util.ArrayList" %>
<%@ page import="model.City" %><%--
  Created by IntelliJ IDEA.
  User: sathnindu
  Date: 2023-10-07
  Time: 07:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="MobileOptimized" content="320">
    <meta name="viewport" content="initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>GoFlow | Request Ride - Destination Location</title>
    <link rel="stylesheet" href="./public/css/styles.css">
    <link rel="icon" type="image/x-icon" href="./public/images/GoFlow-Logo.png">

    <%--  map - leaflet.js  --%>
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.9.4/dist/leaflet.css"
          integrity="sha256-p4NxAoJBhIIN+hmNHrzRCf9tD/miZyoHS5obTRR9BMY=" crossorigin=""/>

    <style>
        #locCities {
            position: absolute;
            background-color: white;
            width: 100%;
            z-index: 10000;
        }
    </style>

</head>
<body>

<%
    ArrayList<City> cities = (ArrayList<City>) request.getAttribute("cityList");
%>

<jsp:include page="/WEB-INF/views/Common/Header.jsp"></jsp:include>

<div class="map-prompter">
    <form action="./DriverWaiting" method="post">
        <div>
<%--            <label for="vehicleType">Select vehicleType type</label>--%>
            <div>
                <select id="vehicleType" name="vehicleType">
                    <option value="tuk">Tuk Ride</option>
                    <option value="car">Car Ride</option>
                    <option value="van">Van Ride</option>
                    <option value="bicycle">Bicycle Ride</option>
                </select>
            </div>

            <input type="hidden" name="location" id="location">
            <input type="hidden" name="start_latitude" id="start_latitude">
            <input type="hidden" name="start_longitude" id="start_longitude">
            <input type="hidden" name="end_latitude" id="end_latitude">
            <input type="hidden" name="end_longitude" id="end_longitude">
            <input type="hidden" name="distance" id="distance">
            <input type="hidden" name="fare" id="fare">

        </div>

        <div style="padding: 20px 0">
            <span>Distance: </span>
            <h2 style="margin-top: 0;"><span id="trip_distance"></span> Km</h2>
            <span>Fare:</span>
            <h1 style="margin: 0;">LKR 232.80</h1>
        </div>

        <div>
            <input type="submit" class="submit-btn" value="Request">
            <input type="button" class="back-btn" value="Cancel" onclick="window.location.href = './AddRide?step=start'">
        </div>
    </form>
</div>

<div id="map" style="outline: none;"></div>

<script>
    function getURLParameters() {
        const searchParams = new URLSearchParams(window.location.search);
        const params = {};

        if (searchParams.has('step')) {
            params.step = searchParams.get('step');
        }

        // Check if "lat" and "lon" parameters exist in the URL
        if (searchParams.has('start_latitude')) {
            params.start_latitude = parseFloat(searchParams.get('start_latitude'));
        }
        if (searchParams.has('start_longitude')) {
            params.start_longitude = parseFloat(searchParams.get('start_longitude'));
        }
        if (searchParams.has('end_latitude')) {
            params.end_latitude = parseFloat(searchParams.get('end_latitude'));
        }
        if (searchParams.has('end_longitude')) {
            params.end_longitude = parseFloat(searchParams.get('end_longitude'));
        }

        return params;
    }

    function nextStep() {
        const {start_latitude, start_longitude, end_latitude, end_longitude} = getURLParameters();
        // window.location.href = "./AddRide?step=type&start_latitude=" + latitude + "&start_longitude=" + longitude + "&end_latitude=" + end_latitude + "&end_longitude=" + end_longitude;
    }
</script>

<%-- leaflet.js - script --%>
<script src="https://unpkg.com/leaflet@1.9.4/dist/leaflet.js"
        integrity="sha256-20nQCchB9co0qIjJZRGuk2/Z9VM+kNiyxNV1lvTlZBo="
        crossorigin=""></script>

<script src="./public/js/location.js"></script>

<script>
    document.getElementById("start_latitude").value = getURLParameters().start_latitude;
    document.getElementById("start_longitude").value = getURLParameters().start_longitude;
    document.getElementById("end_latitude").value = getURLParameters().end_latitude;
    document.getElementById("end_longitude").value = getURLParameters().end_longitude;
    document.getElementById("fare").value = 232.30;

    const distance = calculateDistance(
        getURLParameters().start_latitude,
        getURLParameters().start_longitude,
        getURLParameters().end_latitude,
        getURLParameters().end_longitude
    );

    document.getElementById("distance").value = distance.toFixed(2);

</script>

</body>
</html>
