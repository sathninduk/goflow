<%--
  Created by IntelliJ IDEA.
  User: sathnindu
  Date: 2023-10-12
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="MobileOptimized" content="320">
    <meta name="viewport" content="initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Redirecting...</title>
    <link rel="stylesheet" href="./public/css/styles.css">
    <link rel="icon" type="image/x-icon" href="./public/images/GoFlow-Logo.png">
</head>
<body>

<%
    if (!session.getAttribute("role").equals("Rider")) {
        response.sendRedirect("./Login");
        return;
    }
%>

<% String msg = (String) request.getAttribute("msg"); %>

<script>
    var msg = "<%= msg %>";
    alert(msg);
    window.location.href = "./Login";
</script>

</body>
</html>