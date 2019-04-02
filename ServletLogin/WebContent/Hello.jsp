<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Capgemini India</h1>

		<%
			Cookie ck[] = request.getCookies();
			if (ck != null) {
				String name = ck[0].getValue();
				if (!name.equals("") || name != null) {
					out.print("<br>Welcome, " + request.getAttribute("myname"));
					out.print("<a href='showUser'>Show All Users</a>");
					out.print("<br><a href='logout'>Logout</a>");
				}
			} else {
				out.print("Please login first");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		%>
	</center>
</body>
</html>