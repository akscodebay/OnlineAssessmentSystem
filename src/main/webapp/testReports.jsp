<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Tests Details</title>
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
	<th>Test Date</th>
	<th>Assessment</th>
	<th>Test Marks</th>
	<th>Email Id</th>
	<th>Total Marks</th>
	<th>Result</th>
</tr>
<c:forEach items="${reports}" var="report">
	<tr>
		<td id='testDate<c:out value="<%=++counter%>"></c:out>'>${report.date}</td>
		<td id='assessment<c:out value="<%=counter%>"></c:out>'>${report.assessmentName}</td>
		<td id='marks<c:out value="<%=counter%>"></c:out>'>${report.marks}</td>
		<td id='email<c:out value="<%=counter%>"></c:out>'>${report.email}</td>
		<td id='totalMarks<c:out value="<%=counter%>"></c:out>'>${report.totalMarks}</td>
		<td id='result<c:out value="<%=counter%>"></c:out>'>${report.result}</td>
    </tr>    
</c:forEach>
</table>
</body>
</html>