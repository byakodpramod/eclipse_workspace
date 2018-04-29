<%-- 
    Document   : searchbyuser
    Created on : Sep 24, 2016, 8:51:29 PM
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
                    <h3 class="page-header">Enter the user-id</h3>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
			<div class="row">
			<div class="col-lg-6">
                <form action="searchbyuser.jsp">
					<div class="form-group">
						<label>User-id</label>
						<input class="form-control" name="userid" style="height: 50px; width: 700px;" type="text" />
						<p class="help-block"></p>
						<button type="submit" class="btn btn-primary">Find Reservations!</button>
                    </div>
				</form>
			</div>
			</div>
                        <% 
                           String uid=request.getParameter("userid");
                           if(uid ==null){
                           } else {
                           try { 
            
                                    Class.forName("com.mysql.jdbc.Driver"); 
                                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/airlines","root",""); 
                    
                                    Statement stmt = con.createStatement();
                                    ResultSet rs;
                                    rs = stmt.executeQuery("select * from flight919 where user_id='" + uid + "'");
                                    
                                    rs.last();
                                    int rows = rs.getRow();
                                    String seatsRes[]=new String[15];
                                    int i=0;
                                    %>
                                    <h3> Total seats reserved by this user are: <%=rows%> </h3>
                                    <% rs.beforeFirst();
                                    while (rs.next()) {
                                    String seatReserved = rs.getString ("seat");
                                    seatsRes[i]=seatReserved;
                                    i++;
                        
                                    } %>
                                    
                                    
                                    <% for(String s:seatsRes)
                                    {
                                        if(s==null){
                                        } else {
                                        %>
                                        <P> Seat number: <%=s%> </p>
                                     <% } }%>
                                    
                    <% con.close(); 
                } catch(Exception ex) { 
                    
                    out.println(ex);
            }
                           }
        %>
                            
                    
			</div>
			<br/><br/><br/>
           
        <!-- /#page-wrapper -->
       
    </body>
</html>
