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
	String temp = handler.query4(
			request.getParameter("roomid"),
			request.getParameter("roomtype"),
			Integer.parseInt(request.getParameter("pid")),
			Integer.parseInt(request.getParameter("eid")));

	if (temp == "Success") {
		out.println("Room Details for <b>"+ request.getParameter("roomid")+"</b> has been inserted successfully and assosciated with Patient" + request.getParameter("pid") + "and Nurse"+ request.getParameter("eid"));
	}
	else {
		System.out.println("Data Insertion Failed");
	}
	%>
</body>
</html>