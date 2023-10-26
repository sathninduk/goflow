function calculateDistance(lat1, lon1, lat2, lon2) {
    const earthRadiusKm = 6371; // Radius of the Earth in kilometers

    // Convert latitude and longitude from degrees to radians
    const lat1Rad = toRadians(lat1);
    const lon1Rad = toRadians(lon1);
    const lat2Rad = toRadians(lat2);
    const lon2Rad = toRadians(lon2);

    // Haversine formula
    const dLat = lat2Rad - lat1Rad;
    const dLon = lon2Rad - lon1Rad;

    const a =
        Math.sin(dLat / 2) * Math.sin(dLat / 2) +
        Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.sin(dLon / 2) * Math.sin(dLon / 2);

    const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    // Distance in kilometers
    return earthRadiusKm * c;
}

function toRadians(degrees) {
    return degrees * (Math.PI / 180);
}

function calculateMidpoint(lat1, lon1, lat2, lon2) {
    const a = toRadians(lat1);
    const b = toRadians(lat2);
    const c = toRadians(lon2 - lon1);

    const Bx = Math.cos(b) * Math.cos(c);
    const By = Math.cos(b) * Math.sin(c);

    const d = Math.atan2(
        Math.sin(a) + Math.sin(b),
        Math.sqrt((Math.cos(a) + Bx) ** 2 + By ** 2)
    );

    const e = toRadians(lon1) + Math.atan2(By, Math.cos(a) + Bx);

    return {
        latitude: toDegrees(d),
        longitude: toDegrees(e)
    };
}

function toDegrees(radians) {
    return radians * (180 / Math.PI);
}


// Built-in -------------------------------------------------
function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition, showError, {enableHighAccuracy: true});
    } else {
        console.log("Geolocation is not supported by this browser.");
    }
}

function showPosition(position) {
    const latitude = position.coords.latitude;
    const longitude = position.coords.longitude;
    setMapView(latitude, longitude, "current");
}

function showError(error) {
    switch (error.code) {
        case error.PERMISSION_DENIED:
            console.log("User denied the request for Geolocation.");
            break;
        case error.POSITION_UNAVAILABLE:
            console.log("Location information is unavailable.");
            break;
        case error.TIMEOUT:
            console.log("The request to get user location timed out.");
            break;
        case error.UNKNOWN_ERROR:
            console.log("An unknown error occurred.");
            break;
    }
}

// Call the function to get the location
getLocation();


// Set Map View ------------------------------------------------- leaflet.js
function setMapView(latitude, longitude, type) {

    if (map) {
        map.remove(); // Remove the existing map
    }

    console.log(latitude, longitude);
    document.getElementById("location").value = latitude + ", " + longitude;

    // view
    const {step} = getURLParameters();


    if (step === "type") {
        const {start_latitude, start_longitude, end_latitude, end_longitude} = getURLParameters();

        const distance = calculateDistance(start_latitude, start_longitude, end_latitude, end_longitude); // Berlin to Paris
        // document.getElementById("distance").value = distance.toFixed(2);
        document.getElementById("trip_distance").innerText = distance.toFixed(2);

        const midpoint = calculateMidpoint(start_latitude, start_longitude, end_latitude, end_longitude); // Berlin to Paris

        var setMap = false;

        for (var i = 1; i <= 15; i++) {
            let distRange = 40960 / (Math.pow(2, i - 1));
            if (distance >= distRange) {
                setMap = true;
                console.log("Map zooming: " + (i - 1));
                if (i - 1 === 0)
                    map = L.map('map', {zoomControl: false}).setView([midpoint.latitude, midpoint.longitude], 1);
                else
                    map = L.map('map', {zoomControl: false}).setView([midpoint.latitude, midpoint.longitude], i - 1);
                break;
            }
        }

        if (setMap === false) {
            var map = L.map('map', {zoomControl: false}).setView([midpoint.latitude, midpoint.longitude], 15);
        }


    } else {
        map = L.map('map', {zoomControl: false}).setView([latitude, longitude], 17);
    }

    // marker
    var theMarker = L.marker([latitude, longitude]).addTo(map);
    if (step === "type") {
        const {start_latitude, start_longitude, end_latitude, end_longitude} = getURLParameters();
        theMarker = L.marker([start_latitude, start_longitude]).addTo(map);
        theMarker = L.marker([end_latitude, end_longitude]).addTo(map);
    }

    map.on('click', function (e) {
        lat = e.latlng.lat;
        lon = e.latlng.lng;

        document.getElementById("location").value = lat + ", " + lon;
        //Clear existing marker,

        const {step} = getURLParameters();
        if (step !== "type") {
            if (theMarker !== undefined) {
                map.removeLayer(theMarker);
            }

            theMarker = L.marker([lat, lon]).addTo(map);
        }

    });

    // map
    L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19,
        attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    }).addTo(map);

    // Change the position of the zoom control to top right
    const zoomControl = L.control.zoom({ position: 'bottomright' });
    zoomControl.addTo(map);

    if (type === "current") {
        //var circle =
        L.circle([latitude, longitude], {
            color: 'rgb(85,125,255)',
            fillColor: 'rgba(109,142,255,0.7)',
            fillOpacity: 0.5,
            radius: 200
        }).addTo(map);
    }

    if (step === "type") {
        const {start_latitude, start_longitude, end_latitude, end_longitude} = getURLParameters();

        // var polygon =
        L.polygon([
            [start_latitude, start_longitude],
            [end_latitude, end_longitude]
        ]).addTo(map);
    }
}