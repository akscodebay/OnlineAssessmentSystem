<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Reports</title>
</head>
<body>
<%
String email = request.getParameter("email");
session.setAttribute("sessionId", email);
if(session.getAttribute("sessionId") == null) 
{%>
	<c:redirect url = "/"/>
<%}
%>
<h2 id="msg">Select Reports</h2>
<a href="<c:url value = "/users/all"/>">View list of all candidates</a>
<br>
<a href="<c:url value = "/tests/all"/>">View list of all tests taken</a>
<br>
<a href="<c:url value = "/"/>">Logout</a>
</body>
</html>