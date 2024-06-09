<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.state.model.States" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<% States state = (States) request.getAttribute("key"); %>
</head>
<body>
	<form action="update" method="post">
		<input type="hidden" name="id" value="<%= state.getSid() %>"> <br>
		State Name : <input type="text" name="sname" value="<%= state.getSname() %>" />
		</br></br>
		<input type="submit" value="Update" />
		
	</form>
</body>
</html>