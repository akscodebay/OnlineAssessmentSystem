<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Assessment</title>
</head>
<body>
<%
int counter = 0;
if(session.getAttribute("sessionId") == null) 
{%>
	<c:redirect url = "/"/>
<%}
%>
<h1>Spring Assessment</h1>
<form action="evaluate/spring/test" method="post">
<c:forEach items="${question}" var="questions">
        <b><label>Question <%=++counter%>: ${questions.question}</label></b>
        <br>
        <input id='Q<c:out value="<%=counter%>"></c:out>-Opt1' name='Question<c:out value="<%=counter%>"></c:out>' type="radio" value='<c:out value="${questions.opt1}"></c:out>'>${questions.opt1}<br>
        <input id='Q<c:out value="<%=counter%>"></c:out>-Opt2' name='Question<c:out value="<%=counter%>"></c:out>' type="radio" value='<c:out value="${questions.opt2}"></c:out>'>${questions.opt2}<br>
        <input id='Q<c:out value="<%=counter%>"></c:out>-Opt3' name='Question<c:out value="<%=counter%>"></c:out>' type="radio" value='<c:out value="${questions.opt3}"></c:out>'>${questions.opt3}<br>
        <input id='Q<c:out value="<%=counter%>"></c:out>-Opt4' name='Question<c:out value="<%=counter%>"></c:out>' type="radio" value='<c:out value="${questions.opt4}"></c:out>'>${questions.opt4}<br>
		<input id='Q<c:out value="<%=counter%>"></c:out>-Opt5' name='Question<c:out value="<%=counter%>"></c:out>' type="radio" value="null" style="display:none;" checked><br>
</c:forEach>
<input id="submitspring" type="submit" value="submit Test">
</form>
</body>
</html>