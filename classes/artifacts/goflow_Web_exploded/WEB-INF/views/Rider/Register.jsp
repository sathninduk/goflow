<%--
  Created by IntelliJ IDEA.
  User: sathnindu
  Date: 2023-10-03
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>

<%@page import="model.Rider"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rider Registration | GoFlow</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/Common/Header.jsp"></jsp:include>
	
	<p>Add Rider</p>

	<form method="POST" action="AddRider">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td>Telephone</td>
				<td><input type="text" name="tel"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="Add Rider" class="add-button" /></td>
			</tr>
		</table>
	</form>
	
	
</body>
</html>