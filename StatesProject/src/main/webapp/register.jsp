<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body style="text-align: center">
	<h1>Registration Form</h1>
	
	<form action="states/add" method="post">
		State ID : <input type="text" name="sid"> </br>
		State Name : <input type="text" name="sname"> </br>	
		</br>
		<input type="submit" value="Add" />
	</form>
	</br>
	
	<a href="<%= request.getContextPath() %>/states"> <button>Show States</button>  </a>
	
</body>
</html>