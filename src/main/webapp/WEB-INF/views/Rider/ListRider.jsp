<%--
  Created by IntelliJ IDEA.
  User: sathnindu
  Date: 2023-10-03
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>

<%@page import="model.Rider"%>
<%@page import="service.rider.IRiderService"%>
<%@page import="service.rider.RiderServiceImpl"%>
<%@page import="java.util.ArrayList"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="MobileOptimized" content="320">
	<meta name="viewport" content="initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<title>List Rider</title>
	<link rel="stylesheet" href="./public/css/styles.css">
	<link rel="icon" type="image/x-icon" href="./public/images/GoFlow-Logo.png">
</head>
<body>

<jsp:include page="/WEB-INF/views/Common/Header.jsp"></jsp:include>

<p>List Rider</p>

<br>

<table border="1" cellpadding="12">
		 <caption><h2>List of Riders</h2></caption>
		 <a href="./RiderRegister">Add Rider</a>
		  <tr>
                <th>Rider ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Tel</th>
            </tr>
            <%
           
            IRiderService iRiderService = new RiderServiceImpl();
            ArrayList<Rider> rider = iRiderService.getRiders();
			
			for(Rider r : rider){
			%>
			 <tr>
				<td> <%=r.getID() %> </td>
				<td> <%=r.getName() %> </td>
				<td> <%=r.getEmail() %> </td>
				<td> <%=r.getTel() %> </td>
				<td> 
				<form method="POST" action="GetRider">
				<input type="hidden" name="riderID" value="<%=r.getID()%>"/>
				 <input type="submit" value= "Select Rider" class="select-button" /> 
				 </form>
				 </td>	
				</tr>			
			<%	
			   }
            %>     
		</table>

</body>
</html>