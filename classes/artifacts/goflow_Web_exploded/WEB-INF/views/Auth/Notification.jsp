<%--
  Created by IntelliJ IDEA.
  User: sathnindu
  Date: 2023-10-07
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Redirecting...</title>
  <link rel="icon" type="image/x-icon" href="./public/images/GoFlow-Logo.png">
</head>
<body>

<% String msg = (String) request.getAttribute("msg"); %>

<script>
  var msg = "<%= msg %>";
  alert(msg);
  window.location.href = "./ListRider";
</script>

</body>
</html>