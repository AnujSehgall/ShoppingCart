package com.shoppingCart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shoppingCart.model.UserDTO;

/* A class to validate the authenticity of the user */

public class LoginDAO {

	public static boolean validate(UserDTO dto) {
		boolean status = false;
		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDb", "user", "user");

			PreparedStatement ps = con.prepareStatement("select * from UserDetail where userName=? and userPassword=?");
			ps.setString(1, dto.getUserName());
			ps.setString(2, dto.getPassword());

			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;		//status will hold the final result of the check 
	}
}
