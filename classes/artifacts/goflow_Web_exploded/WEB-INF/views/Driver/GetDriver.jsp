<%--
  Created by IntelliJ IDEA.
  User: sathnindu
  Date: 2023-10-07
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>

<%@page import="model.Driver"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Driver | GoFlow</title>
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