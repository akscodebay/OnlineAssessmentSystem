<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Assessment - Home Page</title>
</head>
<body>
<%session.invalidate(); %>
<h1>Welcome to Online Assessments</h1>
<h3>Login</h3>
<form action="login/do" method="post">
Email ID:<input id="email" name="email" type="email" required>
<br>
Password:<input id="password" name="password" type="password" required>
<br>
<input id="login" type="submit" value="LOGIN">
<br>
New User? <a href="register.html">register here</a>
</form>
</body>
</html>