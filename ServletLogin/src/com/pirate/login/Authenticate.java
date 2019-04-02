package com.pirate.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		String uname = request.getParameter("uname");
		String pswd = request.getParameter("pswd");
		
		if(uname.equals("admin") && pswd.equals("root")) {
			String name = "Shubham";
			request.setAttribute("myname", name);
			RequestDispatcher rd = request.getRequestDispatcher("Hello.jsp");
			rd.forward(request, response);
	        Cookie ck=new Cookie("cname",uname);  
	        response.addCookie(ck);  
		}
		else {
			String loginErr = "Invalid Login";
			request.setAttribute("msg", loginErr);
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
	}

}
