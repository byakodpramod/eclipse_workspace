<%-- 
    Document   : reservation_check
    Created on : Sep 23, 2016, 1:19:04 PM
    Author     : iCodeNext
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*"  session = "true" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Airline Reservation</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/sb-admin-2.css" rel="stylesheet">

        

    </head>
   
<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header" >
                <a class="navbar-brand" href="index.jsp">Airline Reservation System</a>
            </div>
            
            <!-- /.navbar-header -->
		<div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <div>
                                <p style="font-weight: bold; margin: 30px 0px 20px 95px; color: #4d79ff"> Menu </p>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="reservation.jsp"><i class="fa fa-dashboard fa-fw"></i> Available seats</a>
                        </li>
                        <%
                            if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
                        %> 
                        <li>
                            <a href="register.jsp"><i class="fa fa-edit fa-fw"></i> Register</a>
                        </li>
			<li>
                            <a href="login.jsp"><i class="fa fa-edit fa-fw"></i> Login </a>
                        </li>
                        
                        <% } else { %>
                        <li>
                            <a href="logout.jsp"><i class="fa fa-edit fa-fw"></i> Logout </a>
                        </li>
                        <% } %>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
                    
        <div id="page-wrapper">
            <div class="row">
       
        <% 
            String uid=(String)session.getAttribute("userid"); 
            String seat[]=request.getParameterValues("seat");  
            String st=(String)session.getAttribute("status");
            
            if(seat.length > 4)
            {
               response.sendRedirect("reservation.jsp?msg=You can book 4 seats at the max! Please book the seats again.");
               
               return;
            }
             if (st.equals("standard"))
            {
                
                for(int i=0;i<seat.length;i++)
                {
                    int s=Integer.parseInt(seat[i]);
                    if(s<=12)
                    {
                         response.sendRedirect("reservation.jsp?msg=You cannot book luxury seats! Please book the seats again."); 
                         return;
                     }
            }
            }
            
            try { 
            
                    Class.forName("com.mysql.jdbc.Driver"); 
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/airlines","root",""); 
                    for(int s=0;s<seat.length;s++)
                    { 
                    PreparedStatement ps=con.prepareStatement("update flight919 set user_id=?, seat_status=? where seat=?");
                    ps.setString(3,seat[s]);
                    ps.setString(1,uid);
                    ps.setString(2, "booked");
                    int i=ps.executeUpdate();
                    } %>
                    
                    <div class="row">
                    <div class="col-lg-12">
                                  
                    <div class="alert alert-info" style="margin: 20px 0px 0px 0px; width: 500px;">
                        You have booked the seats successfully!
                        </div>
        
                    
                     </div>
                <!-- /.col-lg-12 -->
                     </div>
                    <br/>
                   <% Statement stmt = con.createStatement();
                    ResultSet rs;
                    rs = stmt.executeQuery("select * from flight919 where user_id='" + uid + "'"); 
                    rs.last();
                    int rows = rs.getRow(); %>
                    <h3> Total seats booked by you are : <%=rows%> </h3>
                    <b> Your seat numbers are : </b> <br/>
                   <% rs.beforeFirst();
                    while (rs.next()) {
                        String seatReserved = rs.getString ("seat");
                        
                        out.println(seatReserved + "<br/>");
                        
                    } 
                    con.close(); 
                } catch(Exception ex) { 
                    
                    out.println(ex);
            }
        %>
        
    </body>
</html>
