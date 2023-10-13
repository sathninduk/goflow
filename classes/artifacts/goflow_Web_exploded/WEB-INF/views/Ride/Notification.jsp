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
  <title>Redirecting...</title>
</head>
<body>

<% String msg = (String) request.getAttribute("msg"); %>

<script>
  var msg = "<%= msg %>";
  alert(msg);
  window.location.href = "./Login";
</script>

</body>
</html>