<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Confirmation</title>
</head>
<body>
Registered Successfully!!!
<br>
${user.firstName} ${user.lastName}
<br>
<a href="<c:url value="/"/>">LOGIN</a>
</body>
</html>