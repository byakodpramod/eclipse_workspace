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
                            <a href="reservation.jsp"><i class="fa fa-dashboard fa-fw"></i> Available Seats</a>
                        </li>
                        <li>
                            <a href="login.jsp"><i class="fa fa-edit fa-fw"></i> Login </a>
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
                    <h3 class="page-header">User Registration</h3>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
			<div class="row">
            <div class="col-md-8 col-md-offset-2">
                <div class="panel panel-default" >
                    <div class="panel-heading">
                        <h3 class="panel-title">Register here</h3>
                    </div>
                    <div class="panel-body">
                        <form action="register_check.jsp">
                            <fieldset>
                                <div class="form-group">
					<label> First Name </label>
                                    <input class="form-control" placeholder="E-mail" name="fname" type="text" autofocus>
                                </div>
                                <div class="form-group">
					<label> Last Name </label>
                                    <input class="form-control" placeholder="Password" name="lname" type="text">
                                </div>
                                <div class="form-group">
					<label> User-id </label>
                                    <input class="form-control" placeholder="Password" name="userid" type="text">
                                </div>
                                <div class="form-group">
					<label> Password </label>
                                    <input class="form-control" placeholder="Password" name="password" type="password">
                                </div>
                                <div class="form-group">
					<label> Status </label>
                                    <select class="form-control" placeholder="Password" name="status">
                                        <option value="standard">Standard </option>
                                        <option value="luxury"> Luxury </option>
                                    </select>
                                </div>
				<br/>
                               <br/>
                                <button type="submit" class="btn btn-lg btn-info btn-block">Register</button>
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
