package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import com.bean.UserBean;

@WebServlet("/UpdatePasswordController")
public class UpdatePasswordController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    UserBean user = new UserBean();
    user.setEmail(request.getParameter("email"));
    user.setPassword(request.getParameter("newpassword"));
	/* user.setUserId(Integer.parseInt(request.getParameter("userId"))); */
    
    UserDao userDao = new UserDao();
    if(userDao.updatePasswordUser(user)) {
		request.setAttribute("message", "Updated Successfully");
	}else {
		request.setAttribute("message", "Some error occured");
	}
	request.getRequestDispatcher("Login.jsp").forward(request, response);
   
	}
}
