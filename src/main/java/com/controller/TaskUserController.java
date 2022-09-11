package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserTaskBean;
import Dao.UserDao;

@WebServlet("/TaskUserController")
public class TaskUserController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int userid = (Integer) session.getAttribute("userId");
		System.out.println(userid);
		UserDao userDao = new UserDao();
		ArrayList<UserTaskBean> user = userDao.getAllTaskUsers(userid);
		System.out.println(user);

		int score = 0;
		int total = 0;

		for (UserTaskBean tb : user) {
			//System.out.println(tb.getPriority());
			if (tb.getPriority().equals("High")) {
				total += 100;
			} else if (tb.getPriority().equals("Medium")) {
				total += 50;
			}
			if (tb.getStatus().equals("pending")) {
				System.out.println("Tasks are Pending");
				request.setAttribute("taskPending", "All Task Are Pending");
			} else if (tb.getStatus().equals("Done")) {
				if (tb.getPriority().equals("High")) {
					score += 100;
				} else if (tb.getPriority().equals("Medium")) {
					score += 50;
				}
			}
		}
		int marks = 0;
		if (total == 0) {
			
		} else {
			marks = (score * 100) / total;
		}
		request.setAttribute("marks", marks);

		request.setAttribute("users", user);	
		RequestDispatcher rd = request.getRequestDispatcher("ViewTask.jsp");
		rd.forward(request, response);

	}
}
