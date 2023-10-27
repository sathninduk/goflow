<%@page import="model.Rider"%>
<%@page import="service.rider.IRiderService"%>
<%@page import="service.rider.RiderServiceImpl"%>
<%@page import="java.util.ArrayList"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="MobileOptimized" content="320">
    <meta name="viewport" content="initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>List Riders | GoFlow</title>
    <link rel="stylesheet" href="./public/css/styles.css">
    <link rel="icon" type="image/x-icon" href="./public/images/GoFlow-Logo.png">

    <style>
        /* Internal CSS styles */
        p {
            font-size: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            border-radius: 5px;

        }
        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even){background-color: #f2f2f2}

        th {
            background-color: #04AA6D;
            color: white;
        }
        .select-button {

            padding: 5px 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            -webkit-transition-duration: 0.4s; /* Safari */
            transition-duration: 0.4s;
            background-color: white;
            color: black;
            border: 2px solid dimgrey;
        }

        .select-button:hover {
            background-color: dimgrey;
            color: white;
        }


    </style>


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
    <caption><h2>List of Riders</h2></caption>
    <!--<a href="./RiderRegister">Add Rider</a>-->
    <tr>
        <th>Rider ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Tel</th>
    </tr>
    <%

        IRiderService iRiderService = new RiderServiceImpl();
        ArrayList<Rider> rider = iRiderService.getRiders();

        for(Rider r : rider){
    %>
    <tr>
        <td> <%=r.getID() %> </td>
        <td> <%=r.getName() %> </td>
        <td> <%=r.getEmail() %> </td>
        <td> <%=r.getTel() %> </td>
        <td>
            <form method="POST" action="GetRider">
                <input type="hidden" name="riderID" value="<%=r.getID()%>"/>
                <input type="submit" value= "Select Rider" class="select-button" />
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>