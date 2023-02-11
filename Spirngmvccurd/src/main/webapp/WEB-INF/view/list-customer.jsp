<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customer</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<%
		
	%>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relation Manager</h2>
		</div>
	</div>
	<input type="button" value="Add Customer"
		onclick="window.location.href='addcustomer'; return flase;"
		class="add-button" />
	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>Frist Name</th>
					<th>Frist Name</th>
					<th>Frist Name</th>
					<th>Action</th>
				</tr>
				<!-- Contruct an Update link with customer id -->
				<c:forEach var="tempCustomer" items="${customers}">
					<!-- Update Link -->
					<c:url var="updateLink" value="/customer/updatecustomer">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<!-- Delete Link -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>
							<!-- Display the Update Link --> <a href="${updateLink}">Update</a>
							<!-- Display the Delete Link --> <a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false ">Delete</a></tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>