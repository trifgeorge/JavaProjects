<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Droid+Sans"
	rel="stylesheet">
<title>Login Page</title>
<style>
body {
	background-color: #CEE3F6;
}

div.UpMenu {
	background-color: #0080FF;
	/*margin: 120px 0 120px 0;*/
	width: 1300px;
	height: 180px;
	margin-top: 10px;
	margin-left: 20px;
	border-bottom-left-radius: 25px;
	border-bottom-right-radius: 25px;
}

div.MainBody {
	position: relative;
	background-color: #0080FF;
	width: 1200px;
	height: 400px;
	left: -270px;
	top: -68px;
	border-bottom-left-radius: 25px;
	border-bottom-right-radius: 25px;
}

div.FirstBar {
	background-color: #5858FA;
	width: 1300px;
	height: 9px;
	border-radius: 25px;
}

div.MainBodyFirstBar {
	background-color: #5858FA;
	width: 1200px;
	height: 9px;
	border-radius: 25px;
}

div.SecoundBar {
	position: relative;
	background-color: #5858FA;
	width: 1300px;
	height: 50px;
	top: -190px;
	border-radius: 25px;
}

div.Clock1 {
	position: relative;
	left: 220px;
	top: 18px;
}

div.Clock2 {
	position: relative;
	left: 450px;
	top: -67px;
}

div.Clock3 {
	position: relative;
	left: 680px;
	top: -150px;
}

div.Clock4 {
	position: relative;
	left: 910px;
	top: -235px;
}

div.ClockName {
	color: white;
	font-family: Helvetica Neue;
	font-style: normal;
	font-size: 25px;
}

ul {
	list-style-type: none;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	border: 4px solid #5858FA;
	background-color: #0080FF;
	border-radius: 25px;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	font-size: 25px;
	padding: 20px 15px;
	text-decoration: none;
}

li a:hover:not (.active ) {
	background-color: #5858FA;
}

li a.active {
	color: white;
	background-color: #5858FA;
}

div.menu {
	position: relative;
	width: 45%;
	left: 350px;
	top: 40px;
}

.error {
	font-family: 'Droid Sans' padding : 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	font-family: 'Droid Sans' padding : 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	position: relative;
	top: 50px;
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #0080FF;
	border-radius: 25px;
	border: 1px solid white;
}
</style>
</head>
<body onload='document.loginForm.username.focus();'>
	<div class=UpMenu>

		<div class=FirstBar></div>

		<div class=Clock1>

			<iframe
				src="http://free.timeanddate.com/clock/i5ckxvx7/n259/szw80/szh80/hoc000/cf100/hnce1ead6/fas24/mmv0/hsv0"
				frameborder="0" width="80" height="80"></iframe>



		</div>
		<div class=Clock2>
			<iframe
				src="http://free.timeanddate.com/clock/i5cl2ec0/n2210/szw80/szh80/hoc000/cf100/hnce1ead6/fas26/mmv0/hsv0"
				frameborder="0" width="80" height="80"></iframe>
			<div class=Clock21></div>
		</div>
		<div class=Clock3>
			<iframe
				src="http://free.timeanddate.com/clock/i5cl2ec0/n48/szw80/szh80/hoc000/cf100/hnce1ead6/fas26/mmv0/hsv0"
				frameborder="0" width="80" height="80"></iframe>
			<div class=Clock31></div>
		</div>
		<div class=Clock4>
			<iframe
				src="http://free.timeanddate.com/clock/i5cl2ec0/n204/szw80/szh80/hoc000/cf100/hnce1ead6/fas26/mmv0/hsv0"
				frameborder="0" width="80" height="80"></iframe>
			<div class=Clock41></div>
		</div>
		<div class=SecoundBar>
			<div class=ClockName>
				<i style="font-family: 'Droid Sans'">______________________Vienna________________Minsq_______________Brussels_______________Prague______________________________</i>
			</div>
		</div>
	</div>
	<div class=menu>
		<ul>
			<li><a href="http://localhost:8080/SpringMVCHibernate/login"
				style="font-family: 'Droid Sans'">Home</a></li>
			<li><a href="http://localhost:8080/SpringMVCHibernate/airplane"
				style="font-family: 'Droid Sans'">Flights</a></li>
			<li><a href="http://localhost:8080/SpringMVCHibernate/airport"
				style="font-family: 'Droid Sans'">Airports</a></li>
			<li><a href="http://localhost:8080/SpringMVCHibernate/client"
				style="font-family: 'Droid Sans'">MyFlights</a></li>
			<li><a href="http://localhost:8080/SpringMVCHibernate/aboutus"
				style="font-family: 'Droid Sans'">AboutUs</a></li>

		</ul>

		<div class=MainBody>
			<div class=MainBodyFirstBar>
				<div id="login-box">

					<h2 style="font-family: 'Droid Sans'; color: white">Login with
						Username and Password</h2>

					<c:if test="${not empty error}">
						<div class="error">${error}</div>

					</c:if>
					<c:if test="${not empty msg}">
						<div class="msg">${msg}</div>

					</c:if>

					<form name='loginForm'
						action="<c:url value='/j_spring_security_check' />" method='POST'>

						<table>
							<tr>
								<td style="font-family: 'Droid Sans'; color: white">Username:</td>
								<td><input type='text' name='username'></td>
							</tr>
							<tr>
								<td style="font-family: 'Droid Sans'; color: white">Password:</td>
								<td><input type='password' name='password' />
							</tr>
							<tr>

								<td colspan='2'><input onclick="myFunction()"
									style="font-family: 'Droid Sans'" name="submit" type="submit"
									value="SUBMIT" /></td>

							</tr>
						</table>

						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />

					</form>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			function myFunction() {
				window.location = "http://localhost:8080/SpringMVCHibernate/airplane";
			}
		</script>
		<script type="text/javascript">
			function myFunctionn() {
				alert(1);
			}
		</script>
		<footer> </footer>
</body>
</html>