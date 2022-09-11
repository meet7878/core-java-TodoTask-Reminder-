package com.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import com.bean.UserTaskBean;



@WebServlet("/EditTaskController")
public class  EditTaskController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int taskid= Integer.parseInt(request.getParameter("taskid"));
		System.out.println(taskid+"meet");
		UserDao userDao = new UserDao();
		UserTaskBean task = userDao.gettaskdata(taskid);
		System.out.println(task);
		request.setAttribute("tasks", task);
		request.setAttribute("taskid",taskid);
		request.getRequestDispatcher("EditTask.jsp").forward(request, response);
		
	}
	}	
