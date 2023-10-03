<%@page import="model.Rider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get Rider</title>
</head>
<body>
	<%
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