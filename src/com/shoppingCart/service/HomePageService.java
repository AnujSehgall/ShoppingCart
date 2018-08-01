package com.shoppingCart.service;

import java.util.ArrayList;
import java.util.List;

import com.shoppingCart.dao.HomePageDAO;
import com.shoppingCart.model.ProductDTO;

public class HomePageService {

	public List<ProductDTO> diplayProductList() {

		HomePageDAO productsDAO = new HomePageDAO();
		List<ProductDTO> productList = productsDAO.getProductDetails();
		return productList;
	}

}
