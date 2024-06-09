
<%@page import="com.state.service.serviceImpl.StateServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.state.dao.StateDao"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.state.model.States, java.util.ArrayList, com.state.service.StateService, com.state.service.serviceImpl.StateServiceImpl" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>State Page</title>

<% StateService service = (StateService) request.getAttribute("service"); %>
<% List<States> stateList = (List<States>) service.listOfStates(); %>

</head>
<body style="text-align: center">
	<br/>
	
	
	
	<br/>
	<a href="<%= request.getContextPath() %>/register"> <button>Add New States</button> </a>
	<br/><br/>
	<table border="1" align="center" cellpadding="20">
		<tr> <th>State ID</th>	<th>State Name</th>	</tr>
		
		<% for(States state : stateList) { %>
		<tr>
			<td><%= state.getSid() %></td>
			<td><%= state.getSname() %></td>
			<td><a href="<%= request.getContextPath() %>/states/editpage?id=<%= state.getSid() %>"><button>UPDATE</button></a>
			<td><a href="<%= request.getContextPath() %>/states/delete?id=<%= state.getSid() %>"><button>DELETE</button></a>
		</tr>
		<% } %>
	</table>
	
</body>
</html>