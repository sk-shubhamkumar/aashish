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
		<h3>User Registration</h3>

		<form method="post" action="saveUser">
			Name <input type="text" name="name"><br>
			<br> Username <input type="text" name="uname"><br>
			<br> Password <input type="password" name="pswd"><br>
			<br> Mobile <input type="text" name="mobile"><br>
			<br> <input type="submit" value="Register">
		</form>
		<br>
		<a href="login">Login | </a>
		<a href="showUser">Show Users</a>
		<%
			if (request.getAttribute("msg") != null) {
		%>
		<div class="err-msg"><%=request.getAttribute("msg")%></div>
		<%
			}
		%>
	</center>
</body>
</html>