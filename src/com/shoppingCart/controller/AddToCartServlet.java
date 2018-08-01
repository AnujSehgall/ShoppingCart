package com.shoppingCart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import com.shoppingCart.model.ProductDTO;
import com.shoppingCart.model.UserDTO;
import com.shoppingCart.service.AddToCartService;

/**
 * Servlet implementation class AddToCartServelet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		AddToCartService addToCartService = new AddToCartService();
		HttpSession session = request.getSession(false);
		HttpSession sessionForPid = request.getSession();
		PrintWriter out = response.getWriter();
		ProductDTO productDTO = new ProductDTO();
		UserDTO userDTO = new UserDTO();

		productDTO.setProductID(Integer.parseInt(request.getParameter("getProductId")));
		sessionForPid.setAttribute("productId", (Integer.parseInt(request.getParameter("getProductId"))));
		
		addToCartService.addToCart(productDTO,
				(String) session.getAttribute("name"), Integer.parseInt(request.getParameter("quantity")));
		RequestDispatcher rd = request.getRequestDispatcher("HomePage");
		rd.forward(request, response);
	}

}
