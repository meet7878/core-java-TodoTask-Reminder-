package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import Dao.UserDao;


public class SignupController extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("init()");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String sports = request.getParameter("sports");
		
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(email);
		System.out.println(password);
		System.out.println(gender);
		System.out.println(sports);
		
		
		/*else {*/
		
			UserDao userDao= new UserDao();
			
			UserBean userBean = new UserBean(); 
			userBean.setFirstName(firstName);
			userBean.setLastName(lastName);
			userBean.setEmail(email);
			userBean.setPassword(password);
			userBean.setGender(gender);	
			userBean.setSports(sports);
			userBean.setUsertype("customer");
			System.out.println(userBean);
			
			userDao.insertUser(userBean);
//			request.setAttribute("msg","signup done..");
		    request.getRequestDispatcher("Login.jsp").forward(request, response);;
			
		}
	
	
//	}

}
