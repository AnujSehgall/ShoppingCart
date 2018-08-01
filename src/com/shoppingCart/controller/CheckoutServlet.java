package com.shoppingCart.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoppingCart.model.OrderDTO;
import com.shoppingCart.model.ProductDTO;
import com.shoppingCart.service.OrderService;

/**
 * Servlet implementation class OrderServelet
 */
@WebServlet("/OrderCheckout")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=null;
		int productId=0;
		HttpSession session = request.getSession(false);
		HttpSession sessionForPid = request.getSession(false);
		if (session != null && sessionForPid != null) {
			 name = (String) session.getAttribute("name");
			productId = (int) sessionForPid.getAttribute("productId");
			System.out.println("serv "+name+" "+ productId);
			OrderService orderService = new OrderService();
			List<OrderDTO> orderList = orderService.getOrder(name, productId);
			System.out.println(orderList.get(0).toString());
			request.setAttribute("orderList", orderList);

			RequestDispatcher rd = request.getRequestDispatcher("OrderCheckout.jsp");
			rd.include(request, response);
		}

		else {
			System.out.println("Testing");
		}
	}

}
