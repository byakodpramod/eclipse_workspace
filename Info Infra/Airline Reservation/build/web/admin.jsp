<%-- 
    Document   : login
    Created on : Sep 15, 2016, 7:40:19 PM
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
                    <h3 class="page-header">List of all reservations</h3>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
	<div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                   <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i> List
                    </div>
                        <!-- /.panel-heading -->
                        
                            <table class="table table-hover">
				<tr>
				<th> Seat Numbers </th>
				<th> Passenger's user-id </th>
				</tr>
                                <%@page  %>
				<% 
                                
                                try { 
            
                                    Class.forName("com.mysql.jdbc.Driver"); 
                                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/airlines","root",""); 
                                    Statement st = con.createStatement();
                                    ResultSet rs;
                                    rs = st.executeQuery("select * from flight919");
                                    while (rs.next()) {
                                    String id = rs.getString ("user_id");
                                    String seatgiven = rs.getString("seat"); 
                                    
                                %>
                                    
                                    <tr>
					<td> <%=seatgiven%> </td>
					<td> <%=id%> 
					</td>
			
				    </tr>
                                    
                  <%  } 
                } catch(Exception ex) { 
                    
                    out.println(ex);
            } %>				
							
			</table>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    
                </div>
                <!-- /.col-lg-8 -->
            </div>
			
        </div>
        <!-- /#page-wrapper -->

    </div>
    

</body>
</html>
