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
        #map {
            height: 400px;
            width: 100%;
        }

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

<h1>Vehicle Type</h1>

<%
    //    ICityService cityService = new CityServiceImpl();
//    ArrayList<City> cities = cityService.getCitiesBySearch("");

//    for (City city : cities) {
%>
<%--<p>--%>
<%--    <%=city.getName()%>--%>
<%--</p>--%>
<%--<%--%>
<%--    }--%>
<%--%>--%>


<form>
    <div style="display: inline-block;">
        <label for="vehicle">Select vehicle type</label>
        <select id="vehicle" name="vehicle">
            <option value="truck">Tuk</option>
            <option value="car">Car</option>
            <option value="van">Van</option>
            <option value="bus">Bicycle</option>
        </select>

        <input type="hidden" name="location" id="location">
    </div>

    <input type="submit" value="Request">
</form>

<div id="map" style="outline: none;"></div>

<%-- leaflet.js - script --%>
<script src="https://unpkg.com/leaflet@1.9.4/dist/leaflet.js"
        integrity="sha256-20nQCchB9co0qIjJZRGuk2/Z9VM+kNiyxNV1lvTlZBo="
        crossorigin=""></script>

<script src="./public/js/location.js"></script>

</body>
</html>
