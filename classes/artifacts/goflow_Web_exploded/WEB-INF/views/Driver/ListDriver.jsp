<%@page import="model.Driver"%>
<%@page import="service.driver.IDriverService"%>
<%@page import="service.driver.DriverServiceImpl"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="service.vehicleType.IVehicleTypeService" %>
<%@ page import="service.vehicleType.IVehicleTypeServiceImpl" %>
<%@ page import="model.VehicleType" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="MobileOptimized" content="320">
    <meta name="viewport" content="initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>List Drivers | GoFlow</title>
    <link rel="stylesheet" href="./public/css/styles.css">
    <link rel="icon" type="image/x-icon" href="./public/images/GoFlow-Logo.png">
</head>
<body>

<%
    if (!session.getAttribute("role").equals("Admin")) {
        response.sendRedirect("./Login");
        return;
    }
%>

<jsp:include page="/WEB-INF/views/Common/Header.jsp"></jsp:include>
<table border="1" cellpadding="12">
    <caption><h2>List of Drivers</h2></caption>
    <!--<a href="./DriverRegister">Add Driver</a>-->
    <tr>
        <th>Driver ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Tel</th>
        <th>Vehicle Type</th>
    </tr>
    <%

        IDriverService iDriverService = new DriverServiceImpl();
        ArrayList<Driver> driver = iDriverService.getDrivers();

        for(Driver r : driver){
    %>
    <tr>
        <td> <%=r.getID() %> </td>
        <td> <%=r.getName() %> </td>
        <td> <%=r.getEmail() %> </td>
        <td> <%=r.getTel() %> </td>
        <%
            IVehicleTypeService vehicleTypeService = new IVehicleTypeServiceImpl();
            VehicleType vehicleType = vehicleTypeService.getVehicleTypeByID(r.getVehicleType());
        %>
        <td> <%=vehicleType.getName() %> </td>
        <td>
            <form method="POST" action="GetDriver">
                <input type="hidden" name="driverID" value="<%=r.getID()%>"/>
                <input type="submit" value= "Select Driver" class="select-button" />
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>