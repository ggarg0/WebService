<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="org.gaurav.testmartwebservice.Product" %>
    <%@ page import="java.util.*" %>
     <%@ page import="org.gaurav.TestmartServlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<script languages="JavaScript" src="commonfun.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Mart Application</title>
</head>
<body>
<h2> <b><u> <center>TEST MART</center> </u></b></h2><br><br>

<% 

Product category = new Product();
//creating arraylist object of type category class
List<Product> Productlist =new ArrayList<Product>();
//storing passed value from jsp
Productlist = (List) request.getAttribute("ProductDetails");%>
<div class="table-responsive">
<table class="table table-bordered" width="70%" align="center">
<tr>
		<td align="center">		
		Product Id</td>
	<td align="center">		
		Product Price</td>
		<td align="center">		
		Product Available </td>
		<td align="center">		
		Product Description</td>
	</tr>

<%for(int i = 0; i < Productlist.size(); i++) {%>

<tr>
	
		<td align="center">		
		<% out.println(Productlist.get(i).getProductId()); %></td>
	<td align="center">		
		<% out.println(Productlist.get(i).getProductPrice());%></td>
		<td align="center">		
		<% out.println(Productlist.get(i).getProductInStock().toUpperCase());%></td>
		<td align="Left">		
		<%  out.println(Productlist.get(i).getProductDescription().toUpperCase());%></td>
	</tr>



<%

}%>
</table>
</div>
</body>
</html>