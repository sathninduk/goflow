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
    <title>Request Ride - Pickup Location | GoFlow</title>
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
   if (!session.getAttribute("role").equals("Rider")) {
        response.sendRedirect("./Login");
       return;
    }
%>

<jsp:include page="/WEB-INF/views/Common/Header.jsp"></jsp:include>

<div class="map-prompter">
    <h1>Pickup Location</h1>
    <div>
        <div style="display: inline-block; width: calc(100% - 64px); margin: 0 10px 15px 0;">
            <span class="error-message" id="error-loc"></span>
            <input type="text" id="location" name="location" placeholder="Enter city" onfocus="highlightText()">
            <div id="locCities"></div>
        </div>

        <button onclick="window.location.reload()" class="next-btn"><span>&#128204;</span></button>
    </div>
    <button onclick="nextStep()" class="submit-btn">Next</button>
</div>

<div id="mapContainer">
    <div id="map" style="outline: none;"></div>
</div>

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
                        document.getElementById("locCities").innerHTML +=
                            "<p style='cursor: pointer;' onclick=\"addToLoc('" + data[i].name + "', '" + data[i].latitude + "', '" + data[i].longitude + "')\">" +
                            data[i].name + "</p>";
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

<script>
    function getURLParameters() {
        const searchParams = new URLSearchParams(window.location.search);
        const params = {};

        if (searchParams.has('step')) {
            params.step = searchParams.get('step');
        }

        return params;
    }
</script>

<script>
    async function addToLoc(name, latitude, longitude) {

        // delete element
        document.getElementById("map").remove();

        const newDiv = document.createElement('div');
        newDiv.id = 'map';
        const targetElement = document.getElementById('mapContainer');
        targetElement.appendChild(newDiv);

        setMapView(latitude, longitude, "custom");
        document.getElementById("location").value = latitude + ", " + longitude;
        document.getElementById("locCities").innerHTML = "";
    }
</script>

<script>
    // check error flags
    const urlParams = new URLSearchParams(window.location.search);
    if (urlParams.has('flag')) {
        const flag = urlParams.get('flag');
        if (flag === "empty") {
           alert("All inputs are required. Please try again.");
        }

        if (flag === "distance") {
            alert("Locations should fall within a range of 1km to 500km. Please try again.");
        }

        if (flag === "unavailable") {
            alert("No drivers are available from requested vehicle type currently. Please try again later.");
        }
    }
</script>

<script>
    function nextStep() {
        let location = document.getElementById("location");

        // frontend validation
        if (location.value === "") {

            let locError = document.getElementById("error-loc");

            location.classList.add("input-error");
            locError.innerHTML = "Location is required<br><br>";

            return;
        }

        let latitude = parseFloat(location.value.split(", ")[0]);
        let longitude = parseFloat(location.value.split(", ")[1]);

        console.log(latitude, longitude)

        window.location.href = "./AddRide?step=end&latitude=" + latitude + "&longitude=" + longitude;
    }
</script>

<%-- leaflet.js - script --%>
<script src="https://unpkg.com/leaflet@1.9.4/dist/leaflet.js"
        integrity="sha256-20nQCchB9co0qIjJZRGuk2/Z9VM+kNiyxNV1lvTlZBo="
        crossorigin=""></script>

<script src="./public/js/location.js"></script>

</body>
</html>
