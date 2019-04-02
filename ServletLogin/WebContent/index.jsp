<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page session = "false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.err-msg{
		color: red;
	}
</style>
</head>
<body><center>

	<h1>Capgemini India</h1>
	
	<form method="post" action="authenticate">
		Username <input type="text" name="uname"><br><br>
		Password <input type="password" name="pswd"><br><br>
		<input type="submit" value="Login">
	</form>
	<br>
	<% if(request.getAttribute("msg") != null){ %>
	<div class="err-msg"><%= request.getAttribute("msg") %></div>
	<% } %>
	</center>
</body>
</html>