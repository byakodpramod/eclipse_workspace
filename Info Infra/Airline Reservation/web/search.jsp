<%-- 
    Document   : search
    Created on : Sep 24, 2016, 4:02:12 PM
    Author     : iCodeNext
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                            <a href="admin.jsp"><i class="fa fa-dashboard fa-fw"></i> List of all Reservations</a>
                        </li>
                        <li>
                            <a href="searchbyseats.jsp"><i class="fa fa-edit fa-fw"></i> Search by seats</a>
                        </li>
						<li>
                            <a href="searchbyuser.jsp"><i class="fa fa-edit fa-fw"></i> Search by User</a>
                        </li>
                        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
        

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header">Passenger details</h3>
                </div>
                <!-- /.col-lg-12 -->
            </div>
        <% String seat = request.getParameter("btn"); %>
        
        <%@ page import="java.sql.*, java.util.*"  session = "true" %> 
 
 
        
        <% 
         
            try { 
            
                    Class.forName("com.mysql.jdbc.Driver"); 
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/airlines","root",""); 
                    Statement st = con.createStatement();
                    ResultSet rs;
                    rs = st.executeQuery("select * from users where user_id in(select user_id from flight919 where seat='" + seat + "')");
                    if (rs.next()) {
                        String fname = rs.getString("fname");
                        String lname = rs.getString("lname");
                        String user_id = rs.getString("user_id");
                        String status = rs.getString("status"); %>
                       
                        <div class="panel-body">
                            <table class="table table-striped" style="width: 500px; height: 270px;">
                                <tr>
                                    <td> <b> Seat number: </b> </td>
                	            <td> <%=seat%></td>
				</tr>
                                <tr>
                                    <td> <b> First Name: </b> </td>
                	            <td> <%=fname%></td>
				</tr>
                                <tr>
                                    <td> <b> Last Name: </b> </td>
                	            <td> <%=lname%></td>
				</tr>
                                <tr>
                                    <td> <b> User-id: </b> </td>
                	            <td> <%=user_id%></td>
				</tr>
                                <tr>
                                    <td> <b> Status: </b> </td>
                	            <td> <%=status%></td>
				</tr>
                                
								
			    </table>
                        </div>
                        
                        
 
                   <%  } else { 
                        
                       response.sendRedirect("searchbyseats.jsp?msg=This seat is not reserved by any passenger");
                   } 
                   
   

                } catch(Exception ex) { 
                    
                    out.println(ex);
            }  
            
            
        %>

    </body>
</html>
