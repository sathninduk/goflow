<%@page import="java.util.ArrayList" %>
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
    <title>List Vehicle Types< | GoFlow</title>
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
    <caption><h2>List of Vehicle Types</h2></caption>
    <a href="./AddVehicleType">Add Vehicle Type</a>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Rate</th>
    </tr>
    <%

        IVehicleTypeService iVehicleTypeService = new IVehicleTypeServiceImpl();
        ArrayList<VehicleType> vehicleTypes = iVehicleTypeService.getVehicleTypes();

        for (VehicleType v : vehicleTypes) {
    %>
    <tr>
        <td><%=v.getVehicle_id() %>
        </td>
        <td><%=v.getName() %>
        </td>
        <td><%=v.getRate() %>
        </td>
        <td>
            <form method="POST" action="GetVehicleType">
                <input type="hidden" name="vehicleTypeID" value="<%=v.getVehicle_id()%>"/>
                <input type="submit" value="Select VehicleType" class="select-button"/>
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>