package com.shoppingCart.service;

import com.shoppingCart.dao.LoginDAO;
import com.shoppingCart.model.UserDTO;

public class LoginService {

	
	public boolean isAuthentic(UserDTO dto) {
		
		LoginDAO loginDAO = new LoginDAO();
		
		return loginDAO.validate(dto);
		
	}
}
