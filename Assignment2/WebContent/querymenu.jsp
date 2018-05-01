<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
a {
  position: relative;
  display: inline-block;
  transition: .3s;
  text-decoration: none;
}

a::after,
a::before {
  position: absolute;
  left: 0;
  content: &#39;&#39;;
  width: 100%;
  height: 1px;
  background-color: green;
  opacity: 0;
  transition: .3s;
}

a:hover::before {
  top: 0;
  opacity: 1;
}

a:hover::after {
  bottom: 0;
  opacity: 1;
}

a:hover {
  color: green;
}
</style>
</head>
<body>
	<h3><span> Please Select the one of the following: </span></h3>
	<div>
  		<a href="http://localhost:8080/Assignment2/query1.jsp"><span>1. Insert the complete information for a patient </span></a><br/>
  		<a href="http://localhost:8080/Assignment2/query2.jsp"><span>2. Insert the complete information for a nurse </span></a><br/>
  		<a href="http://localhost:8080/Assignment2/query3.jsp"><span>3. Insert the complete information for a doctor and associate him/her with a patient</span></a><br/>
  		<a href="http://localhost:8080/Assignment2/query4.jsp"><span>4. Insert the complete information for a room and associate it with a patient and a nurse</span></a><br/>
  		<a href="http://localhost:8080/Assignment2/query5.jsp"><span>5. Insert the complete information for a medicine and associate it with a patient</span></a><br/>
  		<a href="http://localhost:8080/Assignment2/query6.jsp"><span>6. Find the complete information for all the patients who were in the hospital during a particular month of a particular year (e.g. during July of 2017)</span></a><br/>
  		<a href="http://localhost:8080/Assignment2/query7jsp"><span>7. Find the complete information for all the doctors who care for more than two patients.</span></a><br/>
  		<a href="http://localhost:8080/Assignment2/query8jsp"><span>8. Find the complete information for all the nurses who tend to patients that are given a certain medicine (e.g. medicine code: 123)</span></a><br/>
  		<a href="http://localhost:8080/Assignment2/query9jsp"><span>9. Delete all the patients who were discharged before a particular year</span></a><br/>
  		<a href="http://localhost:8080/Assignment2/query10.jsp"><span>10. Delete all the patients who have not been assigned a room.</span></a><br/>
  	</div>
</body>
</html>