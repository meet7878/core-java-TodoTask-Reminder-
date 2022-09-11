package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import com.bean.UserBean;

@WebServlet("/ForgotController")
public class ForgotController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 String	email = request.getParameter("email");
	 String sports = request.getParameter("sports");
	System.out.println(email);
	 System.out.println(sports);
	 
	 UserDao userDao = new UserDao();
	 UserBean user = userDao.forgot(email,sports);
	 System.out.println(user);
	
		RequestDispatcher rd = null;
		
		if(user == null) {
			request.setAttribute("errormsg", "Invalid valid data");
			rd = request.getRequestDispatcher("ForgetPassword.jsp");	
		}
		else {
			System.out.println(user.getUsertype());
			if(user.getUsertype().equals("customer")){
				request.setAttribute("email",email);
				rd = request.getRequestDispatcher("NewPassword.jsp");
				
			}
			else {
				rd = request.getRequestDispatcher("404.jsp");
			}
			
		}
		rd.forward(request, response);
		
	}
}
