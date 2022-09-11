package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import com.bean.UserTaskBean;

@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
 @Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int a =Integer.parseInt( request.getParameter("taskid"));
	System.out.println("Hello at upDATE"+a);
	 UserTaskBean user= new UserTaskBean();
		user.setTask(request.getParameter("task"));
		user.setDescription(request.getParameter("description"));
		user.setPriority(request.getParameter("priority"));	
		user.setTaskid(a);
		UserDao userDao = new UserDao();
		if(userDao.EditTaskDao(user)) {
			request.setAttribute("message", "Updated Successfully");
		}else {
			request.setAttribute("message", "Some error occured");
		}
		request.getRequestDispatcher("TaskUserController").forward(request, response);
		
		
	}

			
		}


