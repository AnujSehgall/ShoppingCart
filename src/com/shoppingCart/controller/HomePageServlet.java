package com.shoppingCart.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoppingCart.model.ProductDTO;
import com.shoppingCart.model.UserDTO;
import com.shoppingCart.service.HomePageService;

/**
 * Servlet implementation class HomePageServlet
 */
@WebServlet("/HomePage")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDTO loginDTO = new UserDTO();
		HttpSession session = request.getSession(false);
		if (session != null) {
			String name = (String) session.getAttribute("name");

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			HomePageService homePageService = new HomePageService();

			List<ProductDTO> productList = homePageService.diplayProductList();

			request.setAttribute("productList", productList);

			request.getRequestDispatcher("HomePage.jsp").forward(request, response);

			out.close();
		}
	}
}
