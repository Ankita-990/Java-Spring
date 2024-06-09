<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.product.service.ServiceProduct, com.product.model.Product, java.util.List, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<% ServiceProduct service = (ServiceProduct) request.getAttribute("service"); %>
<% List<Product> productList = (List<Product>) service.productServiceList(); %>
</head>
<body style="text-align: center">

	<form action="ProductController/searchproduct">
		Search : <input type="text" name="search" />
		<a href="<%= request.getContextPath() %>/ProductController/searchproduct"><button>Search</button></a>
	</form>
	
	
	
	</br></br>

	<a href="<%= request.getContextPath() %>/product"><button>Add Products</button></a>
	
	<h1>List of Products</h1>

	<table border="1" align="center" cellpadding="20">
		<tr> 
			<th>product id</th> 
			<th>product name</th> 
			<th>product description</th>
			<th>product category</th>
		</tr>
		
		<% for(Product prod : productList) { %>
		<tr>
			<td><%= prod.getPid() %></td>
			<td><%= prod.getPname() %></td>
			<td><%= prod.getPdesc() %></td>
			<td><%= prod.getPcatagory() %></td>
			<td><a href="<%= request.getContextPath() %>/ProductController/edit?id=<%= prod.getPid() %>"><button>Update</button></a></td>
			<td><a href="<%= request.getContextPath() %>/ProductController/delete?id=<%= prod.getPid() %>"><button>Delete</button></a></td>
		</tr>
		<% } %>
	</table>
	
</body>
</html>