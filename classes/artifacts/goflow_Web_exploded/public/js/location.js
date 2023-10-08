// Built-in -------------------------------------------------
function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition, showError, { enableHighAccuracy: true });
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

    var map = L.map('map').setView([latitude, longitude], 12);

    map.on('click', function(e) {
        var coordinates = e.latlng;
        console.log(coordinates);
        addMarker(coordinates);
    });

    function addMarker(coordinates) {
        L.marker(coordinates).addTo(map);
    }

    L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19,
        attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    }).addTo(map);

    var marker = L.marker([latitude, longitude]).addTo(map);

    var circle = L.circle([latitude, longitude], {
        color: 'black',
        fillColor: 'rgba(0,0,0,0.1)',
        fillOpacity: 0.5,
        radius: 15000
    }).addTo(map);

    // var polygon = L.polygon([
    //     [51.509, -0.08],
    //     [51.503, -0.06],
    //     [51.51, -0.047]
    // ]).addTo(map);
}