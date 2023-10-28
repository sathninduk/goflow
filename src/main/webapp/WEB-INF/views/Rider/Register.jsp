<%@page import="model.Rider" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Rider Registration | GoFlow</title>
    <link rel="stylesheet" href="./public/css/styles.css">
    <link rel="icon" type="image/x-icon" href="./public/images/GoFlow-Logo.png">

    <style>
        /* Internal CSS styles */
        body {
            background-color: #f5f5f5;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        p {
            font-size: 24px;
            font-weight: bold;
            margin: 20px 0;
        }

        table {
            width: 100%;
            max-width: 400px;
            margin: 0 auto;
            border-collapse: collapse;
        }

        table td {
            padding: 10px;
        }

        input[type="text"],
        input[type="tel"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .add-button {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
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

<p>Add Rider</p>

<form method="POST" action="AddRider">
    <table>
        <tr>
            <td>Name</td>
            <td><input required type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input required type="email" style="width: 100%" name="email"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input required type="password" name="password"/></td>
        </tr>
        <tr>
            <td>Telephone</td>
            <td><input required type="tel" style="width: 100%" name="tel" pattern="[0-9]{10}" title="Please enter a valid phone number in the format xxxxxxxxxx digits"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   value="Add Rider" class="add-button"/></td>
        </tr>
    </table>
</form>


</body>
</html>