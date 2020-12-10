<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invalid User Page</title>
</head>
<body>
<h1 id="msg">Sorry you are not a registered User !!!</h1>
<a href="<c:url value="/"/>">Home Page</a>
</body>
</html>