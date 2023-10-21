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
<title>Edit Rider | GoFlow</title>
</head>
<body>
<%
	if (!session.getAttribute("role").equals("Admin")) {
		response.sendRedirect("./Login");
	}

		Rider rider = (Rider) request.getAttribute("rider");
	%>
	<p>Get Rider</p>

	<form method="POST" action="UpdateRider">
		<table>
			<tr>
				<td>Rider ID</td>
				<td><input type="text" name="riderID" disabled="disabled"
					value="<%=rider.getID()%>" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"
					value="<%=rider.getName()%>" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"
					value="<%=rider.getEmail()%>" /></td>
			</tr>
			<tr>
				<td>Telephone</td>
				<td><input type="text" name="tel"
					value="<%=rider.getTel()%>" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden" name="riderID"
					value="<%=rider.getID()%>" /> <input type="submit"
					value="Update Rider" class="update-button" /></td>
			</tr>
		</table>
	</form>
	
	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="DeleteRider">
					<input type="hidden" name="riderID"
						value="<%=rider.getID()%>" /> <input type="submit"
						value="Delete Rider" class="delete-button"/>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>