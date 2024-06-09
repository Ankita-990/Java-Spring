<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.product.model.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<% Product product = (Product) request.getAttribute("searchp"); %>
</head>
<body>
	<h2>Product Details</h2>
	<form action="search" method="post">
		Product ID : <%= product.getPid() %>	</br>
		Product Name : <%= product.getPname() %>	</br>
		Product Description : <%= product.getPdesc() %>	</br>
		Product Category : <%= product.getPcatagory() %> </br>	
	</form>
</body>
</html>