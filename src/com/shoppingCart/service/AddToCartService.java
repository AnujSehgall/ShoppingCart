package com.shoppingCart.service;

import com.shoppingCart.dao.AddToCartDAO;
import com.shoppingCart.model.ProductDTO;

public class AddToCartService {

	public void addToCart(ProductDTO productDTO, String userName, int qunatityOrdered) {
		
		AddToCartDAO cartDAO = new AddToCartDAO();
		cartDAO.AddToCart(productDTO, userName, qunatityOrdered);	
	}
}
