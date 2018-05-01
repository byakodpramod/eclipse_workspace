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
	String code = request.getParameter("code");
	if (code != null){
		rset = handler.query8(code);
		if(rset!=null) {
			out.println("Eid|\tEname|\tContactn_o|\tSex|\tSalary|\tStreet|\tCity|\tState|\tZipcode|\tLevel\n");
			while (rset.next ()) {
				out.println("<br/>");
				out.println(rset.getString(1) + " |\t " + rset.getString(2) + " |\t " + rset.getString(3) + " |\t " + rset.getString(4) + " |\t " + rset.getString(5) + " |\t " + rset.getString(6) + " |\t " + rset.getString(7) + " |\t " + rset.getString(8) + " |\t " + rset.getString(9) + " |\t " + rset.getString(10));

/* 				out.println("Patient Id:" + rset.getString(1) + "<br/>");
				out.println("Patient Name:" + rset.getString(2) + "<br/>");
				out.println("Sex:" + rset.getString(3) + "<br/>");
				out.println("Address:" + rset.getString(4) + "<br/>");
				out.println("Day Admitted:" + rset.getString(5) + "<br>") ;
				out.println("Month Admitted:" + rset.getString(6) + "<br/>");
				out.println("Year Admitted:" + rset.getString(7) + "<br/>");
				out.println("Day Discharged:" + rset.getString(8) + "<br/>");
				out.println("Month Discharged:" + rset.getString(9) + "<br/>");
				out.println("Year Discharged:" + rset.getString(10) + "<br>") ; */
/* 				out.println("Contact Number:" + rset.getString(11) + "<br>") ; */ 
				}
			}

	}
	
	%>
</body>
</html>