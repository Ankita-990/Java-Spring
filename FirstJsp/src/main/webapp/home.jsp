<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
	
	<%@include file="header.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Page</title>
</head>
<body>

	<%
		int num = 9/0;
	%>
	
	<h1>Hello Everyone!</h1>
	
	<%
		out.println(7+5);
	%>
	
	</br>
	
	Number is <%= num %>
	
</body>
</html>