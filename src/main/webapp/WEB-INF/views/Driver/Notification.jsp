<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Redirecting...</title>
    <link rel="icon" type="image/x-icon" href="./public/images/GoFlow-Logo.png">
</head>
<body>

<%

    String msg = (String) request.getAttribute("msg"); %>

<script>
    var msg = "<%= msg %>";
    alert(msg);
    window.location.href = "./ListDriver";
</script>

</body>
</html>