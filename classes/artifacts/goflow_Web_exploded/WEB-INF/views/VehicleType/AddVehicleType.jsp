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
    <meta name="MobileOptimized" content="320">
    <meta name="viewport" content="initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Add Vehicle Type | GoFlow</title>
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
%>

<p>Add VehicleType</p>

<form method="POST" action="AddVehicleType">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Rate</td>
            <td><input type="number" name="rate"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   value="Add Vehicle Type" class="add-button"/></td>
        </tr>
    </table>
</form>


</body>
</html>