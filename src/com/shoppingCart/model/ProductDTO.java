package com.shoppingCart.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDTO {

	private String productName;
	private int productID, quantityAvailable, productRate;

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public int getProductRate() {
		return productRate;
	}

	public void setProductRate(int productRate) {
		this.productRate = productRate;
	}
}
