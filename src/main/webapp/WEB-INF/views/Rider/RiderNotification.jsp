<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		window.location.href = "./ListRider";
	</script>

</body>
</html>