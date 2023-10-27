<%@page import="model.Driver"%>
<%@ page import="service.driver.IDriverService" %>
<%@ page import="service.vehicleType.IVehicleTypeService" %>
<%@ page import="service.vehicleType.IVehicleTypeServiceImpl" %>
<%@ page import="model.VehicleType" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Driver | GoFlow</title>
    <link rel="stylesheet" href="./public/css/styles.css">
    <link rel="icon" type="image/x-icon" href="./public/images/GoFlow-Logo.png">
    <style>
        /* Internal CSS styles go here */
        body {
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
        }

        p {
            font-size: 18px;
            text-align: center;
        }

        table {
            border-collapse: collapse;
            margin: 20px auto;
            width: 80%;
        }

        td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }

        input[type="text"] {
            width: 100%;
            padding: 5px;
        }

        .update-button, .delete-button {
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
<jsp:include page="/WEB-INF/views/Common/Header.jsp"></jsp:include>
<%
    if (!session.getAttribute("role").equals("Admin")) {
        response.sendRedirect("./Login");
        return;
    }
    Driver driver = (Driver) request.getAttribute("driver");
%>
<p>Get Driver</p>

<form method="POST" action="UpdateDriver">
    <table>
        <tr>
            <td>Driver ID</td>
            <td><input type="text" name="driverID" disabled="disabled"
                       value="<%=driver.getID()%>" /></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"
                       value="<%=driver.getName()%>" /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"
                       value="<%=driver.getEmail()%>" /></td>
        </tr>
        <tr>
            <td>Vehicle Type</td>
            <td><select name="vehicle">

                <%
                    IVehicleTypeService iVehicleTypeService = new IVehicleTypeServiceImpl();
                    ArrayList<VehicleType> vehicleType = iVehicleTypeService.getVehicleTypes();
                    for (VehicleType v : vehicleType) {

                        if (driver.getVehicleType() == v.getVehicle_id()) { %>
                <option selected value="<%=v.getVehicle_id()%>"><%=v.getName()%></option>
                <% } else { %>
                <option value="<%=v.getVehicle_id()%>"><%=v.getName()%></option>
                <% }
                } %>

            </select></td>
        </tr>
        <tr>
            <td>Telephone</td>
            <td><input type="text" name="tel"
                       value="<%=driver.getTel()%>" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="hidden" name="driverID"
                                   value="<%=driver.getID()%>" /> <input type="submit"
                                                                         value="Update Driver" class="update-button" /></td>
        </tr>
    </table>
</form>

<table>
    <tr>
        <td colspan="2">
            <form method="POST" action="DeleteDriver">
                <input type="hidden" name="driverID"
                       value="<%=driver.getID()%>" /> <input type="submit"
                                                             value="Delete Driver" class="delete-button"/>
            </form>
        </td>
    </tr>
</table>
</body>
</html>