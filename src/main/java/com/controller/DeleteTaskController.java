package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;

@WebServlet("/DeleteTaskController")
public class DeleteTaskController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int taskid = Integer.parseInt(request.getParameter("taskid"));
		UserDao userDao = new UserDao();
		if(userDao.deleteTask(taskid)) {
			request.setAttribute("message", "Deleted Task Successfully");
		}else {
			request.setAttribute("message", "Some error Occured in Dao");
		}
		request.getRequestDispatcher("TaskUserController").forward(request, response);	
	}
}
