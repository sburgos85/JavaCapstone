<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer sign in order confirmation. </title>
</head>

<%
	//read form data
	String favLang = request.getParameter("foodOrder");

	//encode cookie data ... handle case of languages with spaces in them
	favLang = URLEncoder.encode(favLang, "UTF-8");
	
	//create the cookie
	Cookie theCookie = new Cookie("myApp.foodOrder", favLang);
	
	//set the life span ... total number of seconds.
	theCookie.setMaxAge(60*60*24*365); // <-- for one year
	
	// send cookie to browser
	response.addCookie(theCookie);
%>

<body>
The Customer is signed up: ${param.firstName} ${param.lastName}
Customer email is confirmed: ${param.email} 
Customer phone number is confirmed: ${param.phoneNumber}

<br/></br>

Brisket Order Quantity: ${param.foodOrder}

<br/></br>
Payment method selected:${param.paymentMethod}


Thanks! We set your favorite food Order to: ${param.foodOrder}
	
	<br/><br/>
	
	<a href="cookies-homepage.jsp">Return to homepage.</a>
</body>
</html>