package com.shoppingCart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shoppingCart.model.OrderDTO;
import com.shoppingCart.model.ProductDTO;

public class CheckoutDAO {

	public List<OrderDTO> getOrder(String username, int productId) {
		List<OrderDTO> list1 =null;
		OrderDTO orderDetail =null;
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDb", "user", "user");

			PreparedStatement ps = con.prepareStatement("select * from cartTable where userName = ? ");
			ps.setString(1, username);
			
			list1 = new ArrayList<OrderDTO>();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				orderDetail = new OrderDTO();
				orderDetail.setProductName(rs.getString("userName"));
				orderDetail.setProductId(rs.getInt("ProductId"));
				orderDetail.setQuantity(rs.getInt("quantity"));

				list1.add(orderDetail);
			}
			// con.close();
			return list1;
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return list1;
	}
}
