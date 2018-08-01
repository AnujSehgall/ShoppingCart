package com.shoppingCart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shoppingCart.model.ProductDTO;

/* A class to get all the available products in the store with their name,id,rate and quantity available */

public class HomePageDAO {

	public List<ProductDTO> getProductDetails() {
		List<ProductDTO> list = null;
		ProductDTO productDetail = null;
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDb", "user", "user");

			PreparedStatement ps = con.prepareStatement("select * from productdetail");
			list = new ArrayList<ProductDTO>();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				productDetail = new ProductDTO();
				productDetail.setProductID(rs.getInt("ProductId"));
				productDetail.setProductName(rs.getString("ProductName"));
				productDetail.setQuantityAvailable(rs.getInt("AvailableQuantity"));
				productDetail.setProductRate(rs.getInt("Rate"));

				list.add(productDetail);

			}
			return list;

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;

	}
}
