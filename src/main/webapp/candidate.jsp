<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Tests</title>
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
<div id="msg">Select the Test</div>
<br>
<a href="<c:url value = "/springAssessment.html"/>">Spring Assessment</a>
<br>
<a href="<c:url value = "/hibernateAssessment.html"/>">Hibernate Assessment</a>
<br>
<a href="<c:url value = "/"/>">Logout</a>
</body>
</html>