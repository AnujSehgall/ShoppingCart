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

import com.shoppingCart.dao.LoginDAO;
import com.shoppingCart.model.ProductDTO;
import com.shoppingCart.model.UserDTO;
import com.shoppingCart.service.HomePageService;
import com.shoppingCart.service.LoginService;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
		LoginService loginService = new LoginService();
		UserDTO logindto = new UserDTO();
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String name=request.getParameter("username");  
	    String password=request.getParameter("userpass");  
	    
	    
	    logindto.setUserName(name);
	    logindto.setPassword(password);
	    
	    if(loginService.isAuthentic(logindto)){  
	    	HttpSession session=request.getSession();  
	        session.setAttribute("name",logindto.getUserName()); 
	      RequestDispatcher rd=request.getRequestDispatcher("HomePage");  
	        rd.forward(request,response);  
	        
	    }  
	    else{  
	        out.print("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
	        rd.include(request,response);  
	    }  
	          
	    out.close();  
	    }  
}
