<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="cs5513.DataHandler"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	DataHandler handler = new DataHandler();
	String temp = handler.query10();
	if (temp == "Success"){
			out.println("Records Deleted Sucessfully");
	}
	else{
		out.println("Failed");
	}
	%>
</body>
</html>