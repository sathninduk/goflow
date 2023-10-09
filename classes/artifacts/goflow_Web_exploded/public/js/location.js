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
    setMapView(latitude, longitude);
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


// API Service -------------------------------------------------
//
// function httpGetAsync(url, callback) {
//     fetch(url)
//         .then(response => {
//             if (!response.ok) {
//                 throw new Error('Network response was not ok');
//             }
//             return response.text();
//         })
//         .then(data => {
//             setMapView(JSON.parse(data).latitude, JSON.parse(data).longitude);
//         })
//         .catch(error => {
//             console.error('There has been a problem with your fetch operation:', error);
//         });
// }
//
//
// const url = "https://ipgeolocation.abstractapi.com/v1/?api_key=9175d2a6fe5844b2b17be21a1b0f934d"
//
// httpGetAsync(url)


// Set Map View ------------------------------------------------- leaflet.js
function setMapView(latitude, longitude) {

    console.log(latitude, longitude);
    document.getElementById("location").value = latitude + ", " + longitude;

    // view
    var map = L.map('map').setView([latitude, longitude], 17);

    // marker
    var theMarker = L.marker([latitude, longitude]).addTo(map);

    map.on('click',function(e){
        lat = e.latlng.lat;
        lon = e.latlng.lng;

        document.getElementById("location").value = lat + ", " + lon;
        //Clear existing marker,

        if (theMarker !== undefined) {
            map.removeLayer(theMarker);
        }

        theMarker = L.marker([lat,lon]).addTo(map);
    });

    // map
    L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19,
        attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    }).addTo(map);

    var circle = L.circle([latitude, longitude], {
        color: 'rgb(85,125,255)',
        fillColor: 'rgba(109,142,255,0.7)',
        fillOpacity: 0.5,
        radius: 200
    }).addTo(map);

    // var polygon = L.polygon([
    //     [51.509, -0.08],
    //     [51.503, -0.06],
    //     [51.51, -0.047]
    // ]).addTo(map);
}