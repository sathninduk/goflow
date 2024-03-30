# GoFlow Online Transport System

## Project Description
GoFlow is a transport management system that allows users to book and manage their trips. The system is designed to be used by both customers and drivers. Customers can book trips, view their trip history, and cancel trips. Drivers can view their trip history, accept or reject trip requests, and cancel trips. The system also allows admins to view all trips, view all users, and view all drivers.

## Project Structure
The project is divided into 3 main packages: `model`, `exception`, `service`, `util`, `view`, and `controller`. The `model` package contains all the classes that represent the data model of the system. The `view` package contains all the classes that represent the user interface of the system. The `controller` package contains all the servlets of the system. The `service` package contains all the classes that handle the business logic of the system. The `util` package contains all the classes that handle the database connection and queries. The `exception` package contains all the classes that handle the exceptions of the system. Both `service` and `controller` packages are divided into 6 sub-packages: `admin`, `auth`, `driver`, `ride`, `rider`, and `vehicleType`. Each sub-package contains all the classes that handle the business logic of the system for each function.

## How to run the project
1. Import `goflow.sql` file into MySQL database
2. Change the database connection details in the `application.properties` file in the `util` folder
3. Change the query file path (queryPath) in the `application.properties` file in the `util` folder
4. Setup jdk (version 19)
5. Setup tomcat server version 10.1 (servlet library: jakarta)
6. Import libraries from the tomcat `lib` folder
7. Import project's `lib` folder libraries into the project
8. Run the project on the tomcat server or else run the web archive artifact war file on the tomcat server

## Credentials
### Admin
| Username        | Password |
|-----------------|----------|
| admin@admin.com | wow123   |

### Driver
| Username         | Password |
|------------------|----------|
| bim@gmail.com    | wow123   |

### Rider
| Username         | Password |
|------------------|----------|
|sathnindu@gmail.com| wow123   |

## Features
### Admin
- Manage riders
- Manage drivers
- Manage vehicle types and rates

### Driver
- Accept or reject trip requests
- Update ride status
- Cancel trips

### Rider
- Book trips
- View trip history
- Cancel trips
- View trip details

## Technologies
- Java (Version 19)
- Servlets (Jakarta)
- JSP
- MySQL (Version 8.0)
- HTML, CSS, JavaScript, JSON
- Tomcat (Version 10.1)
- Eclipse EE IDE (Version 2023-06)
- IntelliJ IDEA (Version 2023.2.2)
- MySQL Workbench (Version 8.0)
- DataGrip (Version 2023.2.2)
- GitHub & GitHub Desktop
- Openstreetmap API (https://www.openstreetmap.org/)
- Leaflet API (https://leafletjs.com/)
- GeoLocation API (https://developer.mozilla.org/en-US/docs/Web/API/Geolocation_API)

## References
- https://chat.openai.com/
- https://www.w3schools.com/
- https://leafletjs.com/reference.html
- https://developer.mozilla.org/en-US/docs/Web/API/Geolocation_API


