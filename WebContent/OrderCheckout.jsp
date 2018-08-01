<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.io.File"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import = "com.shoppingCart.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Checkout Page</h1>
<table border=1>
<tr>
<th>Product ID</th>
<th>Product Name</th>
<th>Product Available Quantity</th>
<th>Product Price</th>
<th>Please enter the quantity</th>

</tr>
<%
	if(request.getAttribute("orderList")!=null){
  List<OrderDTO> orders=(ArrayList<OrderDTO>)request.getAttribute("orderList"); 
  for(OrderDTO order: orders) {
%>

<tr>
    <td><%=order.getUsername()%></td>
    <td><%=order.getProductName()%></td>

</tr>

<%}}%>
</table> 

</form>
</body>
</html>