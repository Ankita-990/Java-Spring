<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.ajax.service.ServiceProduct, com.ajax.model.Product, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
<% ServiceProduct service = (ServiceProduct) request.getAttribute("service"); %>
<% List<Product> products = (List<Product>) service.productServiceList(); %>
</head>
<body>

	<form action="add" method="get">
		Product ID : <input type="text" name="pid" />
		Product Name : <input type="text" name="pname" />
		Product Description : <input type="text" name="pdesc" />
		Product Category : <input type="text" name="pcatg" />
	</form>

	<h1>Display products</h1>
	
	<table>
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Description</th>
			<th>Product Category</th>
		</tr>
		
		<% for(Product product : products) { %>
			<tr>
				<td><%= product.getPid() %></td>
				<td><%= product.getPname() %></td>
				<td><%= product.getPdesc() %></td>
				<td><%= product.getPcatagory() %></td>
			</tr>
		<% } %>
	</table>
	
</body>
</html>