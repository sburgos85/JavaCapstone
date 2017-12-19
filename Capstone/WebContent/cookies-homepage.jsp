<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.net.URLDecoder" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cookies Home page</title>
</head>
<body>
<h3>Prior BBQ Order History</h3>

<!-- read the favorite programming language cookie -->
<%
	// the default ... if there are no cookies
	String favLang = "1 pound, Rice, Beans, Banana Pudding";

	// get the cookies from the browser request
	Cookie[] theCookies = request.getCookies();
	
	//find our favorite language cookie
	if (theCookies != null) {
		for (Cookie tempCookie: theCookies)	{
			if("myApp.foodOrder".equals(tempCookie.getName())) {
				favLang = URLDecoder.decode(tempCookie.getValue(), "UTF-8");
				break;
			}
		}
	}
%>

<!--  now show a personalized page ... use the "favLang" variable -->

<!--  show new books for this lang -->
<h4> Previous Order <%= favLang %></h4>
<ul>
	<li> Thank you for ordering with Sam's BBQ!</li>
	<li> Please keep in mind that custom orders require a 24 hour notice.</li>
</ul>

<h4> This weekend's coupon deal: <%= favLang %></h4>
<ul>
	<li> 20% off</li>
	<li> Free drink with the purchase of a child's meal in addition to adult meal.</li>
</ul>


<hr>
<a href="customer-orderform.html">Personalize this page or to Reorder</a>

<hr>

<a href="businesscasual.jsp">Return to Home Page.</a>


</body>

</html>