package com.pirate.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pirate.bean.User;
import com.pirate.dao.UserDAO;


@WebServlet("/saveUser")
public class saveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String uname = request.getParameter("uname");
		String pswd = request.getParameter("pswd");
		String mobile = request.getParameter("mobile");

		User user = new User();
		user.setId(mobile);
		user.setName(name);
		user.setUsername(uname);
		user.setPassword(pswd);
		
		System.out.println(user);

		int status;
		try {
			status = UserDAO.saveUser(user);
			if (status > 0) {
				out.print("User save Successfully!!!");
				request.getRequestDispatcher("registration.jsp").include(request, response);
			} else {
				out.print("Not saved!!!");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
