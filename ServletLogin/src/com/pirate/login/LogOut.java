package com.pirate.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String logoutMsg = "you are successfully logged out!";
		request.setAttribute("msg", logoutMsg);
		request.getRequestDispatcher("index.jsp").include(request, response);

		Cookie ck = new Cookie("cname", "");
		ck.setMaxAge(0);
		response.addCookie(ck);


	}

}
