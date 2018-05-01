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
	String temp = handler.query1(
			request.getParameter("pid"),
			request.getParameter("name"),
			request.getParameter("sex"),
			request.getParameter("address"),
			Integer.parseInt(request.getParameter("day_ad")),
			Integer.parseInt(request.getParameter("month_ad")),
			Integer.parseInt(request.getParameter("year_ad")),
			Integer.parseInt(request.getParameter("day_dis")),
			Integer.parseInt(request.getParameter("month_dis")),
			Integer.parseInt(request.getParameter("year_dis")),
			request.getParameter("contactno1"),
			request.getParameter("contactno2"));
	
	if (temp == "Success") {
		out.println("Patient Details <b>"+ request.getParameter("pid")+"</b> has been inserted successfully");
	}
	else {
		System.out.println("Data Insertion Failed");
	}
	%>
</body>
</html>