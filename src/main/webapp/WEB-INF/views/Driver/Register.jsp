<%--
  Created by IntelliJ IDEA.
  User: sathnindu
  Date: 2023-10-03
  Time: 09:53
  To change this template use File | Settings | File Templates.
--%>

<%@page import="model.Driver" %>
<%@ page import="service.vehicleType.IVehicleTypeService" %>
<%@ page import="service.vehicleType.IVehicleTypeServiceImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.VehicleType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Driver Registration | GoFlow</title>
    <link rel="stylesheet" href="./public/css/styles.css">
    <link rel="icon" type="image/x-icon" href="./public/images/GoFlow-Logo.png">
</head>
<body>
<%
    if (session.getAttribute("id") != null) {
        response.sendRedirect("./Login");
        return;
    }
%>

<jsp:include page="/WEB-INF/views/Common/Header.jsp"></jsp:include>

<p>Add Driver</p>

<%
    IVehicleTypeService vehicleTypeService = new IVehicleTypeServiceImpl();
    ArrayList<VehicleType> vehicleTypes = vehicleTypeService.getVehicleTypes();
%>

<form method="POST" action="AddDriver">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" required/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" required/></td>
        </tr>
        <tr>
            <td>Vehicle Type</td>
            <td>
                <select name="vehicleType" required>
                    <option value="">-- Select --</option>
                    <% for (VehicleType vehicleType : vehicleTypes) { %>
                    <option value="<%=vehicleType.getVehicle_id()%>"><%=vehicleType.getName()%></option>
                    <% } %>
                </select>
            </td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" required/></td>
        </tr>
        <tr>
            <td>Telephone</td>
            <td><input type="text" name="tel" required/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   value="Add Driver" class="add-button"/></td>
        </tr>
    </table>
</form>


</body>
</html>