<%-- 
    Document   : login_check
    Created on : Sep 23, 2016, 12:12:29 PM
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
            String pass=request.getParameter("password"); 
           
            try { 
            
                    Class.forName("com.mysql.jdbc.Driver"); 
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/airlines","root",""); 
                    Statement st = con.createStatement();
                    ResultSet rs;
                    rs = st.executeQuery("select * from users where user_id='" + uid + "' and password='" + pass + "'");
                    if (rs.next()) {
                        String status = rs.getString ("status");
                        session.setAttribute("userid", uid);
                        session.setAttribute("status", status);
                        response.sendRedirect("reservation.jsp");
                    } else {
                        
                        response.sendRedirect("login.jsp?msg=Login Failed!! Please try again!!! ");
                }

                } catch(Exception ex) { 
                    
                    out.println(ex);
            } 
        %>

    </body>
</html>
