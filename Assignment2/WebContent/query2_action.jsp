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
	String temp = handler.query2(
			Integer.parseInt(request.getParameter("eid")),
			request.getParameter("name"),
			request.getParameter("contactno"),
			request.getParameter("sex"),
			Integer.parseInt(request.getParameter("salary")),
			request.getParameter("street"),
			request.getParameter("city"),
			request.getParameter("state"),
			Integer.parseInt(request.getParameter("zipcode")),
			request.getParameter("level"));
	
	if (temp == "Success") {
		out.println("Nurse Details <b>"+ request.getParameter("eid")+"</b> has been inserted successfully");
	}
	else {
		System.out.println("Data Insertion Failed");
	}
	%>
</body>
</html>