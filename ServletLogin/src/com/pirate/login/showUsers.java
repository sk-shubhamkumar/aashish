package com.pirate.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pirate.bean.User;
import com.pirate.dao.UserDAO;

@WebServlet("/showUser")
public class showUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("User Detail List: ");
		
		List<User> list;
		try {
			list = UserDAO.getAllUser();
			out.print("<table border='1' width='70%'>");
			out.print("<tr><th>Name</th><th>UserName</th><th>Mobile No</th><th>Edit</th><th>Delete</th></tr>");
			for(User user : list) {
				out.print("<tr ><td>"+user.getName()+"</td><td>"+user.getUsername()+"</td><td>"+user.getId()+"</td><td>Edit</td><td>Delete</td></tr>");
			}
			out.print("</table>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
