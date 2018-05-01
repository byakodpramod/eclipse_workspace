<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="cs5513.DataHandler"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	DataHandler handler = new DataHandler();
	String temp = handler.query5(
			request.getParameter("code"),
			request.getParameter("medname"),
			Integer.parseInt(request.getParameter("pid")),
			Integer.parseInt(request.getParameter("quantity")));

	
	if (temp == "Success") {
		out.println("Medicine details for <b>"+ request.getParameter("code")+"</b> has been inserted successfully and assosciated with Patient" + request.getParameter("pid"));
	}
	else {
		System.out.println("Data Insertion Failed");
	}
	%>
</body>
</html>

