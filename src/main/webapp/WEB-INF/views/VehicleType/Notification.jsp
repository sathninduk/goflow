<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="MobileOptimized" content="320">
    <meta name="viewport" content="initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Redirecting...</title>
</head>
<body>

<%
    if (!session.getAttribute("role").equals("Admin")) {
        response.sendRedirect("./Login");
        return;
    }
%>

<% String msg = (String) request.getAttribute("msg"); %>

<script>
    var msg = "<%= msg %>";
    alert(msg);
    window.location.href = "./ListVehicleType";
</script>

</body>
</html>