<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<h1>Registration</h1>
<form action="registration/do" method="post">
First Name:<input id="firstname" name="firstName" type="text" placeholder="First Name" pattern="[A-Za-z]+" required>
<br>
Last Name:<input id="lastname" name="lastName" type="text" placeholder="Last Name" pattern="[A-Za-z]+" required>
<br>
Email ID:<input id="email" name="email" type="email" placeholder="email@site.com" required>
<br>
Password:<input id="password" name="password" type="password" placeholder="password" pattern=".{8,}" required>
<br>
<input id="register" type="submit" value="REGISTER"> 	
</form>
</body>
</html>