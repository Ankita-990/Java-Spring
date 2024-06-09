<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.product.model.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<% Product product = (Product) request.getAttribute("key"); %>
</head>
<body>
	<form action="update" method="post">
		<input type="hidden" name="id" value="<%= product.getPid() %>" />
		Product Name : <input type="text" name="pname" value="<%= product.getPname() %>"/>	</br>
		Product Description : <input type="text" name="pdesc" value="<%= product.getPdesc() %>" />	</br>
		Product Category : <input type="text" name="pcatg" value="<%= product.getPcatagory() %>" />	</br>
		
		</br></br>
		
		<input type="submit" value="Update Product" />
	</form>
</body>
</html>