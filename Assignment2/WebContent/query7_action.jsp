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
	ResultSet rset;

		rset = handler.query7();
		if(rset!=null) {
			int i = 1;
			out.println("Eid|\tEname|\tContactn_o|\tSex|\tSalary|\tStreet|\tCity|\tState|\tZipcode|\tSpecialization\n");
			while (rset.next ()) {
				out.println("<br/>");
				out.println(rset.getString(1) + " |\t " + rset.getString(2) + " |\t " + rset.getString(3) + " |\t " + rset.getString(4) + " |\t " + rset.getString(5) + " |\t " + rset.getString(6) + " |\t " + rset.getString(7) + " |\t " + rset.getString(8) + " |\t " + rset.getString(9) + " |\t " + rset.getString(10));
				}
			}	
	%>
</body>
</html>