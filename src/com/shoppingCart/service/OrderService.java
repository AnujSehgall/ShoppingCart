package com.shoppingCart.service;

import java.util.ArrayList;
import java.util.List;

import com.shoppingCart.dao.CheckoutDAO;
import com.shoppingCart.dao.AddToCartDAO;
import com.shoppingCart.model.OrderDTO;
import com.shoppingCart.model.ProductDTO;

public class OrderService {

	public List<OrderDTO> getOrder(String username, int productId) {

		CheckoutDAO checkoutDAO = new CheckoutDAO();
		List<OrderDTO> finalOrderList;
		System.out.println("test " + username + productId);
		finalOrderList = checkoutDAO.getOrder(username, productId);

		return finalOrderList;
	}
}
