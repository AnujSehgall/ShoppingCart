package com.shoppingCart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shoppingCart.model.UserDTO;
import com.shoppingCart.model.ProductDTO;

public class AddToCartDAO {

	public static void AddToCart(ProductDTO productDTO, String userName, int qunatityOrdered) {
		Connection con = null;
		int price = 0,availbleqty=0;
		try {			
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDb", "user", "user");
			
			PreparedStatement productPrice=con.prepareStatement("select * from productdetail where ProductId = ?");  
			productPrice.setInt(1, productDTO.getProductID());
			ResultSet rs = productPrice.executeQuery();
			while(rs.next()){
			price = rs.getInt(4);}
			
			PreparedStatement ps = con.prepareStatement("insert into cartTable values(null, ?,?,?,?,null);");
			ps.setString(1, userName);
			ps.setInt(2, productDTO.getProductID());
			ps.setInt(3, qunatityOrdered);
			ps.setInt(4, (qunatityOrdered*price));

			ps.executeUpdate();
			
			PreparedStatement checkQuantity=con.prepareStatement("select AvailableQuantity from productdetail where ProductId = ?");  
			checkQuantity.setInt(1, productDTO.getProductID());
			ResultSet result = checkQuantity.executeQuery();
			while(result.next()){
			availbleqty = result.getInt("AvailableQuantity");}
			System.out.println(availbleqty);
			
			if (availbleqty > 0) {
				PreparedStatement updateProductTable = con.prepareStatement("Update productdetail set AvailableQuantity =  ? where  ProductId = ?");
				updateProductTable.setInt(1, availbleqty-qunatityOrdered);
				updateProductTable.setInt(2, productDTO.getProductID());
				
				updateProductTable.executeUpdate();
			}
			
			else {
				System.out.println("Product Unavailable");
			}
			
			

		} catch (Exception e) {
			System.out.println(e);
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
