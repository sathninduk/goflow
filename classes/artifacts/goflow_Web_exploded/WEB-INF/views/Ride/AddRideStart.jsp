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
    <title>GoFlow | Request Ride - Pickup Location</title>
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

<h1>Pickup Location</h1>

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
        <label for="location">Pickup Location</label>
        <input type="text" id="location" name="location" placeholder="Enter city" onfocus="highlightText()">
        <div id="locCities"></div>
    </div>

    <input type="submit" value="Next">
</form>

<div id="map" style="outline: none;"></div>

<script>
    document.getElementById("location").addEventListener("input", function () {
        document.getElementById("locCities").innerHTML = "";
        let location = document.getElementById("location").value;

        if (location !== "") {
            let url = "./ListCity?city=" + location;

            fetch(url)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    return response.json(); // Parse the JSON from the response
                })
                .then(data => {
                    // Work with the JSON data
                    for (let i = 0; i < data.length; i++) {
                        document.getElementById("locCities").innerHTML += "<p>" + data[i].name + "</p>";
                    }
                })
                .catch(error => {
                    console.error('There has been a problem with your fetch operation:', error);
                });

        }

    });
</script>

<script>
    function highlightText() {
        const input = document.getElementById('location');
        input.select();
    }
</script>

<%-- leaflet.js - script --%>
<script src="https://unpkg.com/leaflet@1.9.4/dist/leaflet.js"
        integrity="sha256-20nQCchB9co0qIjJZRGuk2/Z9VM+kNiyxNV1lvTlZBo="
        crossorigin=""></script>

<script src="./public/js/location.js"></script>

</body>
</html>
