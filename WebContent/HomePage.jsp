<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.File"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.shoppingCart.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to Shopping Website</h1>

	</form>

	<table border=1>
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Available Quantity</th>
			<th>Product Price</th>
			<th>Please enter the quantity</th>

		</tr>
		<%
			if (request.getAttribute("productList") != null) {
				List<ProductDTO> products = (ArrayList<ProductDTO>) request.getAttribute("productList");
				for (ProductDTO product : products) {
		%>

		<tr>
			<td><%=product.getProductID()%></td>
			<td><%=product.getProductName()%></td>
			<td><%=product.getQuantityAvailable()%></td>
			<td><%=product.getProductRate()%></td>


			<form method="post" action="AddToCartServlet">
				<td><input type="text" name="quantity"></td>
				<td><button type="submit" name="getProductId"
						value="<%=product.getProductID()%>">Add to cart</button>
			</form>
			</td>

		</tr>

		<%
			}
		}
		%>

	</table>


	</form>
	</br>
	</br>
	</br>

	<form method="post" action="OrderCheckout">
		<button type="submit" name="getProductId">Checkout</button>
	</form>
</body>
</html>