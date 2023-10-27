<%@page import="model.Rider" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Rider | GoFlow</title>
    <link rel="stylesheet" href="./public/css/styles.css">
    <link rel="icon" type="image/x-icon" href="./public/images/GoFlow-Logo.png">

    <style>
        /* Internal CSS styles */
        body {
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        p {
            font-size: 24px;
            font-weight: bold;
        }

        table {
            margin: 20px;
            width: 100%;
            border-collapse: collapse;
        }

        table td {
            padding: 10px;
        }

        input[type="text"] {
            width: 100%;
            padding: 5px;
        }

        .update-button {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }

        .delete-button {
            background-color: #dc3545;
            color: #fff;
            padding: 10px 20px;
            border: none;
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

    Rider rider = (Rider) request.getAttribute("rider");
%>
<p>Get Rider</p>

<form method="POST" action="UpdateRider">
    <table>
        <tr>
            <td>Rider ID</td>
            <td><input required type="text" name="riderID" disabled="disabled"
                       value="<%=rider.getID()%>"/></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input required type="text" name="name"
                       value="<%=rider.getName()%>"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input required type="text" name="email"
                       value="<%=rider.getEmail()%>"/></td>
        </tr>
        <tr>
            <td>Telephone</td>
            <td><input required type="text" name="tel"
                       value="<%=rider.getTel()%>"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="hidden" name="riderID"
                                   value="<%=rider.getID()%>"/> <input type="submit"
                                                                       value="Update Rider" class="update-button"/></td>
        </tr>
    </table>
</form>

<table>
    <tr>
        <td colspan="2">
            <form method="POST" action="DeleteRider">
                <input type="hidden" name="riderID"
                       value="<%=rider.getID()%>"/> <input type="submit"
                                                           value="Delete Rider" class="delete-button"/>
            </form>
        </td>
    </tr>
</table>
</body>
</html>