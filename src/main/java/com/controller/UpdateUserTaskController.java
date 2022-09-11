package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserTaskBean;
import Dao.UserDao;

@WebServlet("/UpdateUserTaskController")
public class UpdateUserTaskController extends HttpServlet {
 
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserTaskBean update = new UserTaskBean();
		update.setStatus("Done");
		/* update.setTaskid((Integer.parseInt(request.getParameter("taskid"))); */
		update.setTaskid(Integer.parseInt(request.getParameter("taskid")));
		System.out.println(update);
		
		
		UserDao userDao = new UserDao();
		if(userDao.updateUser(update)) {
			request.setAttribute("message", "Updated Successfully");
		}else {
			request.setAttribute("message", "Some error occured");
		}
		request.getRequestDispatcher("TaskUserController").forward(request, response);
		
		
	}
}
