<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer sign in order confirmation.</title>
</head>
<body>
The Customer is signed up: ${param.firstName} ${param.lastName}
Customer email is confirmed: ${param.email} 
Customer phone number is confirmed: ${param.phoneNumber}

<br/></br>

Brisket Order Quantity: ${param.brisketQuantity}

<br/></br>
Payment method selected:${param.paymentMethod}


</body>
</html>