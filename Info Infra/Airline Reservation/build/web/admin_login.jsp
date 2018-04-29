<%-- 
    Document   : login
    Created on : Sep 15, 2016, 7:40:19 PM
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
        </nav>

        <div id="page-wrapper" style="margin: 0px 0px 0px 0px;">
            <div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header">Admin Login</h3>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
			<div class="row">
            <div class="col-md-8 col-md-offset-2">
                <div class="panel panel-default" >
                    <div class="panel-heading">
                        <h3 class="panel-title">Login here</h3>
                    </div>
                    <div class="panel-body">
                        <form action="adlogin_check.jsp">
                            <fieldset>
                                <div class="form-group">
					<label> User-id </label>
                                    <input class="form-control" placeholder="User-id" name="userid" type="text" autofocus>
                                </div>
                                <div class="form-group">
					<label> Password </label>
                                    <input class="form-control" placeholder="Password" name="password" type="password">
                                </div>
				<br/>
                               
                                <button type="submit" class="btn btn-lg btn-info btn-block">Login</button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
			
        </div>
        <!-- /#page-wrapper -->

    </div>
    

</body>
</html>
