<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>

	<title>Food Order Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>


	<div id ="wrapper">
			<div id ="header">
				<h2>Sam's BBQ</h2>
			</div>
		</div>

	<div id="container">
	
		<div id="content">
		
			<table>
			
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Phone Number</th>
					<th>Order Number</th>
					<th>Order Description</th>
					<th>Action</th>
				</tr>
				
					<c:forEach var="newOrder" items="${CUSTOMER_ORDERLIST}">
						
						<!-- set up a link for each order -->
						<c:url var="templink" value="CustomerControllerServlet">
							<c:param name="command" value="LOAD" />
							<c:param name="custOrderNumber" value="${newOrder.id}"/>
						</c:url>
						
						<!-- set up a link to delete an order -->
						<c:url var="deleteLink" value="CustomerControllerServlet">
							<c:param name="command" value="DELETE" />
							<c:param name="custOrderNumber" value="${newOrder.id}"/>
						</c:url>
						
					<tr>
						<td> ${newOrder.id}</td>
						<td> ${newOrder.firstName} </td>
						<td> ${newOrder.lastName} </td>
						<td> ${newOrder.email} </td>
						<td> ${newOrder.phoneNumber} </td>
						<td> ${newOrder.orderNumber} </td>
						<td> ${newOrder.orderDescription} </td>
						<td> <a href= "${templink}">Update</a>
							  |
							 <a href="${deleteLink}"
							 onclick="if (!(confirm('Are you sure you want to delete this order?'))) return false">
							 Delete</a>
						</td>
					</tr>
					
				</c:forEach>
				
			</table>
		
		</div>
		
	</div>

</body>

</html>