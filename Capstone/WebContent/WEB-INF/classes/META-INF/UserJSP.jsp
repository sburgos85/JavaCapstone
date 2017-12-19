<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Output Table for Database Users</title>
<meta name ="viewport" content ="width=device-width">
</head>
<body>
	<div> Writing Body Content</div>
	<p> Message: ${Update}</p>
	<table>
		<tr>
			<th> User List</th>
			<td>User: ${User.firstName}</td>
			<td>User: ${User2.firstName}</td>
			<td>User: ${User3.firstName}</td>
    </table>
</body>
</html>