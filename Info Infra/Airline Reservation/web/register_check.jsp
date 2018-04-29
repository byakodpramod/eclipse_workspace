<%-- 
    Document   : login_check
    Created on : Sep 23, 2016, 11:39:47 AM
    Author     : iCodeNext
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page import="java.sql.*, java.util.*"  session = "true" %> 
 
 
        
        <% 
            String uid=request.getParameter("userid"); 
            String fname=request.getParameter("fname"); 
            String lname=request.getParameter("lname"); 
            String pass=request.getParameter("password"); 
            String status=request.getParameter("status"); 
            try { 
            
                    Class.forName("com.mysql.jdbc.Driver"); 
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/airlines","root",""); 
                    PreparedStatement ps=con.prepareStatement("insert into users values(?,?,?,?,?)") ;
                    ps.setString(1,uid);
                    ps.setString(2,fname);
                    ps.setString(3,lname);
                    ps.setString(4,pass); 
                    ps.setString(5,status);
                    int i=ps.executeUpdate();
                    if(i!=0) {
                        
                        response.sendRedirect("index.jsp?msg=Thank You for registering with us! Please Login. "); 
                    } else { 
                        response.sendRedirect("register.jsp?msg=Registration Failed!! Please try again!!! ");
                        
                    } 
                    con.close(); 
                } catch(Exception ex) { 
                    
                    out.println(ex);
            } 
        %>

    </body>
</html>
