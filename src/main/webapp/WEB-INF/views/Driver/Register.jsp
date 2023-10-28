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
    <style>
        /* Internal CSS styles go here */
        body {
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
            text-align: center;
        }

        p {
            font-size: 24px;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
        }

        td {
            padding: 12px;
        }

        select, input[type="text"],
        input[type="tel"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 5px;
        }

        .add-button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 5px;
            cursor: pointer;
        }
    </style>
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
            <td><input type="email" style="width: 100%" name="email" required/></td>
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
            <td><input type="tel" style="width: 100%" name="tel" pattern="[0-9]{10}" title="Please enter a valid phone number in the format xxxxxxxxxx digits" required/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   value="Add Driver" class="add-button"/></td>
        </tr>
    </table>
</form>
</body>
</html>