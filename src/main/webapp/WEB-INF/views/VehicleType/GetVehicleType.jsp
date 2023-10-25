<%--
  Created by IntelliJ IDEA.
  User: sathnindu
  Date: 2023-10-03
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>

<%@page import="model.VehicleType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Vehicle Type | GoFlow</title>
    <link rel="stylesheet" href="./public/css/styles.css">
    <link rel="icon" type="image/x-icon" href="./public/images/GoFlow-Logo.png">
</head>
<body>
<jsp:include page="/WEB-INF/views/Common/Header.jsp"></jsp:include>
<%
    if (!session.getAttribute("role").equals("Admin")) {
        response.sendRedirect("./Login");
        return;
    }
    VehicleType vehicleType = (VehicleType) request.getAttribute("vehicleType");
%>
<p>Get VehicleType</p>

<form method="POST" action="UpdateVehicleType">
    <table>
        <tr>
            <td>VehicleType ID</td>
            <td><input type="text" name="vehicleTypeID" disabled="disabled"
                       value="<%=vehicleType.getVehicle_id()%>"/></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"
                       value="<%=vehicleType.getName()%>"/></td>
        </tr>
        <tr>
            <td>Rate</td>
            <td><input type="text" name="rate"
                       value="<%=vehicleType.getRate()%>"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="hidden" name="vehicleTypeID" value="<%=vehicleType.getVehicle_id()%>"/> <input
                    type="submit" value="Update Vehicle Type" class="update-button"/></td>
        </tr>
    </table>
</form>

<table>
    <tr>
        <td colspan="2">
            <form method="POST" action="DeleteVehicleType">
                <input type="hidden" name="vehicleTypeID"
                       value="<%=vehicleType.getVehicle_id()%>"/> <input type="submit"
                                                                         value="Delete VehicleType"
                                                                         class="delete-button"/>
            </form>
        </td>
    </tr>
</table>
</body>
</html>