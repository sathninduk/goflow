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