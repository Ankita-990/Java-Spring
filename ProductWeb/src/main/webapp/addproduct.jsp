<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="jquery-3.7.1.min.js"></script>

<script>
	$(document).ready(function(){
		alert();
	})
</script>

</head>
<body>
	<form action="ProductController/add" method="post">
		Product ID : <input type="text" name="pid" />	</br>
		Product Name : <input type="text" name="pname" />	</br>
		Product Description : <input type="text" name="pdesc" />	</br>
		Product Category : <input type="text" name="pcatg" />	</br>
		
		</br></br>
		
		<input type="submit" value="Add Product" />
	</form>
	
	<a href="<%= request.getContextPath() %>/ProductController"><button>Show Products List</button></a>
	
</body>
</html>