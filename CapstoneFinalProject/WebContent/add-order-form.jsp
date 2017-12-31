<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add BBQ Order</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-order-style.css">
	
</head>
<body>

	<div id ="wrapper">
			<div id ="header">
				<h2>Sam's BBQ</h2>
			</div>
		</div>

	<div id="container">
		<h3> Add Order</h3>
		<form action="CustomerControllerServlet" method = "GET">
		
			<input type ="hidden" name ="command" value = "ADD"/>
			
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>   
						<td><input type="text" name ="firstName"/></td>
					</tr>
					<tr>
						<td><label>Last name:</label></td>   
						<td><input type="text" name ="lastName"/></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>   
						<td><input type="text" name ="email"/></td>
					</tr>
					<tr>
						<td><label>Phone Number:</label></td>   
						<td><input type="text" name ="phoneNumber"/></td>
					</tr>
					
					<tr>
						<td><label>Order Number:</label></td>   
						<td><input type="text" name ="orderNumber"/></td>
					</tr>
					
					<tr>
						<td><label>Order Description:</label></td>   
						<td><input type="text" name ="orderDescription"/></td>
					</tr>
					<tr>
						<td><label></label></td>   
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
		</tbody>
	</table>
	
		
</form>
	</div>
	<div style="clear: both;"></div>
	
	<p>
		<a href="CustomerControllerServlet">Back to List</a>
	</p>
	
</body>
</html>