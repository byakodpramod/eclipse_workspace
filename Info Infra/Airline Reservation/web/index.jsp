

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Airline Reservation System</title>
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
        </nav>

        <div id="page-wrapper" style="margin: 0px 0px 0px 0px;">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <% String msg = request.getParameter("msg"); 
                        if (msg != null) {
                    %>
                    <div class="alert alert-info" style="margin: 20px 0px 0px 250px; width: 400px;">
                        <a href="searchbyseats.jsp" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <%=msg%>
                        </div>
        
                    <% } %>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <h3 class="page-header">Select to proceed further!</h3>
                </div>
            </div>
            <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"></h3>
                    </div>
                    <div class="panel-body">
                        
                        <a href="login.jsp"><button type="submit" class="btn btn-lg btn-info btn-block">User Login</button></a>
                        <br/><br/><br/>
                        <a href="admin_login.jsp"><button type="submit" class="btn btn-lg btn-info btn-block">Admin Login</button></a>
                            
                    </div>
                </div>
            </div>
        </div>
			
        </div>
        <!-- /#page-wrapper -->

    </div>
    

    </body>
</html>
