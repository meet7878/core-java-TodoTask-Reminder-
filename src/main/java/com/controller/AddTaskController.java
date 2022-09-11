package com.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import com.bean.UserTaskBean;

@WebServlet("/AddTaskController")
public class AddTaskController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int userid = (Integer) session.getAttribute("userId");
		
		String task = request.getParameter("task");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String description = request.getParameter("description");
		String priority = request.getParameter("priority");
		
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd"); 
		String startdate = s.format(d);
		System.out.println(startdate);
		
boolean isError = false;
		
		if(task == null || task.trim().length()==0) {
			isError = true;
			request.setAttribute("taskError","Please Enter TaskName");
		}
			else {
				request.setAttribute("taskValue", task);
			}
		RequestDispatcher rd = null;
		if(isError == true) {
		  request.getRequestDispatcher("AddTask.jsp").forward(request, response);;	
		}
		else {
			UserDao userDao= new UserDao();	
			UserTaskBean userTaskBean = new UserTaskBean();
			userTaskBean.setUserid(userid);
			userTaskBean.setTask(task);
			userTaskBean.setDate(date);
			userTaskBean.setTime(time);
			userTaskBean.setDescription(description);
			userTaskBean.setPriority(priority);
			userTaskBean.setStartdate(startdate);
			userTaskBean.setStatus(startdate);
			userTaskBean.setStatus("pending");
			
		
			userDao.insertUserTask(userTaskBean);
			request.setAttribute("msg","Task Added Sucessfully...");
			rd = request.getRequestDispatcher("TaskUserController");
		
	}
		rd.forward(request, response);

	}
}
