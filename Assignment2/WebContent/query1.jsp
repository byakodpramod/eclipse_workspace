<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Information of Patient</title>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>
	<h3 align="center">
		<jsp:useBean id="empsbean" class="cs5513.DataHandler" scope="session" />
	</h3>
	<div class="container-contact100">
		<div class="contact100-map" id="google_map" data-map-x="40.722047" data-map-y="-73.986422" data-pin="images/icons/map-marker.png" data-scrollwhell="0" data-draggable="1"></div>

		<div class="wrap-contact100">
			<div class="contact100-form-title" style="background-image: url(images/bg-01.jpg);">
				<span class="contact100-form-title-1">
					CS 5513 Web Application Page 1 of 10
				</span>

				<span class="contact100-form-title-2">
					Insert a New Patient Records
				</span>
				<span class="contact100-form-title-1">
					<a href="http://localhost:8080/Assignment2/querymenu.jsp"><span style="font-size:1.6em;">Return</span></a><br/>
				</span>
			</div>

			<form action = "query1_action.jsp">
			
				<div class="wrap-input100 validate-input"> &nbsp; Patient Id:  &nbsp;
					<input type="text" name="pid" />
				</div>
				
				<div class="wrap-input100 validate-input"> &nbsp; Name:  &nbsp;
					<input type="text" name="name" />
				</div>
				
				<div class="wrap-input100 validate-input"> &nbsp; Sex:  &nbsp;
					<input type="text" name="sex" />
				</div>
				
				<div class="wrap-input100 validate-input"> &nbsp; Address:  &nbsp;
					<input type="text" name="address" />
				</div>
				
				<div class="wrap-input100 validate-input"> &nbsp; Day of Admission:  &nbsp;
					<input type="text" name="day_ad" />
				</div>
				
				<div class="wrap-input100 validate-input"> &nbsp; Month of Admission:  &nbsp;
					<input type="text" name="month_ad" />
				</div>
				
				<div class="wrap-input100 validate-input"> &nbsp; Year of Admission:  &nbsp;
					<input type="text" name="year_ad" />
				</div>
				
				<div class="wrap-input100 validate-input"> &nbsp; Day of Discharge:  &nbsp;
					<input type="text" name="day_dis" />
				</div>
				
				<div class="wrap-input100 validate-input"> &nbsp; Month of Discharge:  &nbsp;
					<input type="text" name="month_dis" />
				</div>
				
				<div class="wrap-input100 validate-input"> &nbsp; Year of Discharge:  &nbsp;
					<input type="text" name="year_dis" />
				</div>
				
				<div class="wrap-input100 validate-input"> &nbsp; Contact No #1:  &nbsp;
					<input type="text" name="contactno1" />
				</div>
				
				<div class="wrap-input100 validate-input"> &nbsp; Contact No #2:  &nbsp;
					<input type="text" name="contactno2" />
				</div>

				<div class="container-contact100-form-btn">
					<button class="contact100-form-btn">
						<span>
							Insert Patient Details
							<i class="fa fa-long-arrow-right m-l-7" ></i>
						</span>
					</button>
				</div>
			</form>
		</div>
	</div>



	<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKFWBqlKAGCeS1rMVoaNlwyayu0e0YRes"></script>
	<script src="js/map-custom.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
	<script>
	  window.dataLayer = window.dataLayer || [];
	  function gtag(){dataLayer.push(arguments);}
	  gtag('js', new Date());

	  gtag('config', 'UA-23581568-13');
	</script>
</body>
</html>