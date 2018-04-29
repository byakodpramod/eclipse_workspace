<%-- 
    Document   : reservation
    Created on : Sep 23, 2016, 12:24:42 PM
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
                <div class="col-lg-12">
                    <% String msg = request.getParameter("msg"); 
                            if (msg != null) {
                     %>
                    <div class="alert alert-info" style="margin: 20px 0px 0px 0px; width: 500px;">
                        <a href="reservation.jsp" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <%=msg%>
                        </div>
        
                    <% } %>
                </div>
                <!-- /.col-lg-12 -->
            </div>
                <div class="row">
                <div class="col-lg-12">
                    <%
                        if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
                     %>              
                    <div class="alert alert-danger" style="margin: 20px 0px 0px 0px; width: 700px;">
                        <h3> You are not logged in. Please login! </h3>
                        </div>
        
                    
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <% } else {%>
        <div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header"> Welcome <%=session.getAttribute("userid")%>
                    </h3>
                </div>
                <!-- /.col-lg-12 -->
         </div>
       
        
        
        
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default" style="margin: 30px 0px 0px 0px;">
                   <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i> <b> Please Select seats </b>
                    </div>
       
       
       
        <div class="panel-body" style="margin: 0px 40px 0px 40px;">
        <form action="reservation_check.jsp">
         
        <%! int count=0; 
            int[] remainingSeats = new int[80];
        %>
        <%@ page import="java.sql.*, java.util.*"  session = "true" %> 

        <% 
            for(int sr=0;sr<80;sr++){
                remainingSeats[sr]=0;
            }
            try { 
            
                    Class.forName("com.mysql.jdbc.Driver"); 
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/airlines","root","");
                    Statement st = con.createStatement();
                    ResultSet rs;
                    
                    int i = 0;
                    String query = "select seat from flight919 where seat_status='null'";
                    rs = st.executeQuery( query );
                    while(rs.next()) {
                        int s = Integer.parseInt(rs.getString("seat"));
                        remainingSeats[i] = s;
                        i++;
                    }
                    con.close(); 
                } catch(Exception ex) { 
                    
                    out.println(ex);
            }
            
            for(int j=0;j<remainingSeats.length;j++)
            {
                
                    if(remainingSeats[j] != 0){
         %>
         <div class="col-sm-3">
         <p> <%=remainingSeats[j]%> &nbsp;&nbsp;&nbsp;
             <input type="checkbox" name="seat" value="<%=remainingSeats[j]%>" style="width: 20px; height: 20px;"/>
          </div>
         </p>
         
         <% } }%>
             
        
         
        </div><br/><br/>
        <button type="submit" class="btn btn-lg btn-info btn-block" style="width: 400px; margin: 0px 0px 40px 260px;">Book Seats</button>
        </form>
          <% }%>
        </div>
            </div>
        </div>
        </div>
        
    </body>
</html>
