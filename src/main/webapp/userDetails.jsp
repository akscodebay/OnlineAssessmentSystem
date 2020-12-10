<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All User Details</title>
</head>
<body>
<%
int counter = 0;
if(session.getAttribute("sessionId") == null) 
{%>
	<c:redirect url = "/"/>
<%}
%>
<h1>List of All Users</h1>
<table>
<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Email ID</th>
	<th>User Type</th>
</tr>
<c:forEach items="${users}" var="user">
	<tr>
		<td id='firstName<c:out value="<%=++counter%>"></c:out>'>${user.firstName}</td>
		<td id='lastName<c:out value="<%=counter%>"></c:out>'>${user.lastName}</td>
		<td id='email<c:out value="<%=counter%>"></c:out>'>${user.email}</td>
		<td id='userType<c:out value="<%=counter%>"></c:out>'>${user.userType}</td>
    </tr>    
</c:forEach>
</table>
</body>
</html>