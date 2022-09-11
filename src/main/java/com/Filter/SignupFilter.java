package com.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import Dao.UserDao;

@WebServlet("/SignupFilter")
public class SignupFilter implements Filter {
	@Override
	public void destroy() {
		System.out.println("SignupFilterDestroy()");
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter From SignupFilter");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String sports = request.getParameter("sports");
		System.out.println(sports);
		
boolean isError = false;
		
		if(firstName == null || firstName.trim().length()==0) {
			isError = true;
			request.setAttribute("firstNameError","Please Enter FirstName");
		}
			else {
				request.setAttribute("firstNameValue", firstName);
			}
		
		
		if(lastName == null || lastName.trim().length() == 0) {
			isError = true;
			request.setAttribute("lastNameError","Please Enter lastName");
		}else {
			request.setAttribute("lastNameValue", lastName);
		}
		
		if(password == null || password.trim().length() == 0) {
			isError = true;
			request.setAttribute("passwordError","Please Enter Password");
		}else {
			request.setAttribute("passwordValue", password);
		}
		
		if(email == null || email.trim().length()==0) {
			isError = true;
			request.setAttribute("emailError", "Please Enter Email");
			
		}else {
			request.setAttribute("emailValue", email);
		}
		
		if(gender == null) {
			isError=true;
			request.setAttribute("genderError", "Please Select Gender");
		}else {
			request.setAttribute("genderValue" , gender);
		}
		
		UserDao duplicate = new UserDao();
		Boolean user = duplicate.ValidEmail(email);
		
		if(user) {
			request.setAttribute("setemail", "Duplicate Eamil not Valid");
			isError = true;
		}
		
		if(isError == true) {
		  request.getRequestDispatcher("Signup.jsp").forward(request, response);;	
		}
		else {
			//go ahead
			chain.doFilter(request, response);////servlet -- second filter
		}
		
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("SignupFilterInit()");
		
	}

}
