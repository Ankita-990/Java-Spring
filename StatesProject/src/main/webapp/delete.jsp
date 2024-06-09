<%@ page import="com.state.model.States" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<% States state = new States(); %>
</head>
<body>
	<form action="delete" method="post">
		<input type="hidden" name="sid" value="<%= state.getSid() %>" />
	</form>
</body>
</html>