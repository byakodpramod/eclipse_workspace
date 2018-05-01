<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="cs5513.DataHandler"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page Successful</title>
</head>
<body>
	<%	 
		DataHandler handler = new DataHandler(); 
		boolean temp = handler.authenticateUser(
				request.getParameter("username"),
				request.getParameter("password"));
		if(temp) {
			response.sendRedirect("http://localhost:8080/Assignment2/querymenu.jsp");	
		    }
		else {
			out.println("Invalid Username or Password");	
		    } 

	 %>

</body>
</html>