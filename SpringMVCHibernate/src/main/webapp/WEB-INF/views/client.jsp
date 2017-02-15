<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Droid+Sans"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyFlights</title>
<style>
body {
	background-color: #CEE3F6;
	font-family: 'Droid Sans';
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
	left: 70px;
	top: 73px;
	border-bottom-left-radius: 25px;
	border-bottom-right-radius: 25px;
}

div.MainBodyFirstBar {
	background-color: #5858FA;
	width: 1200px;
	height: 9px;
	border-radius: 25px;
}

div.FirstBar {
	background-color: #5858FA;
	width: 1300px;
	height: 9px;
	border-radius: 25px;
}

div.SecoundBar {
	position: relative;
	background-color: #5858FA;
	width: 1300px;
	height: 50px;
	top: -280px;
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
	top: -63px;
}

div.Clock3 {
	position: relative;
	left: 680px;
	top: -143px;
}

div.Clock4 {
	position: relative;
	left: 910px;
	top: -225px;
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

li:hover {
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

div.Logout {
	position: relative;
	top: -310px;
	left: 1150px;
	width: 120px;
	height: 80px;
	background-color: #0080FF;
	font-family: Helvetica Neue;
	border-radius: 25px;
	border: 2px solid #5858FA;

	/*z-index:-1;*/
}

div.Userimg {
	position: relative;
	left: 10px;
	font-family: 'Droid Sans';
	color: white;
}

div.Logoutimg {
	position: relative;
	left: 10px;
	font-family: 'Droid Sans';
	/*text-shadow: 1px 1px;*/
	color: white;
}

div.Messagesimg {
	position: relative;
	float: left;
	left: 10px;
	font-family: 'Droid Sans';
	color: white;
}

div.Rssimg {
	position: relative;
	left: 15px;
	float: left;
}

div.Buddylistimg {
	position: relative;
	left: 20px;
	float: left;
}

tableairplane {
	color: #333;
	font-family: 'Droid Sans';
	width: 640px;
	border-collapse: collapse;
	border-spacing: 0;
}

abbrevTable {
	color: #333;
	font-family: 'Droid Sans';
	width: 400px;
	border-collapse: collapse;
	border-spacing: 0;
}

td, th {
	border: 1px solid transparent; /* No more visible border */
	height: 30px;
	transition: all 0.3s; /* Simple transition for hover effect */
}

th {
	background: #DFDFDF; /* Darken header a bit */
	font-weight: bold;
}

td {
	background: #FAFAFA;
	text-align: center;
}

/* Cells in even rows (2,4,6...) are one color */
tr:nth-child(even) td {
	background: #F1F1F1;
}

/* Cells in odd rows (1,3,5...) are another (excludes header cells) */
tr:nth-child(odd) td {
	background: #FEFEFE;
}

tr td:hover {
	background: #666;
	color: #FFF;
} /* Hover cell effect! */
}
</style>
</head>
<body>

	<!-- SQL -->
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/lic" user="root" password="root" />

	<c:set var="name" value="${pageContext.request.userPrincipal.name}" />
	<sql:query dataSource="${snapshot}" var="resultid">
SELECT client_id FROM Client
WHERE username=?
<sql:param value="${name}" />
	</sql:query>

	<c:forEach var="rowid" items="${resultid.rows }">
		<c:set var="clientId" scope="session" value="${rowid.client_id}" />
		<sql:query dataSource="${snapshot}" var="result">
SELECT Airplane.airplane_id, Airplane.aircrafttype, Airplane.departure, Airplane.arrival, 
Airplane.fromm, Airplane.too, Airplane.delay

FROM Airplane
JOIN client_airplane 
WHERE client_airplane.client_id=? and airplane.airplane_id=client_airplane.airplane_id
<sql:param value="${rowid.client_id}">
			</sql:param>
		</sql:query>


	</c:forEach>

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

		<div class=Logout>
			<div class=Userimg>
				<img src="<c:url value="/resources/img/user.png"/>" />${pageContext.request.userPrincipal.name}
			</div>
			<div class=Logoutimg>
				<a href="javascript:formSubmit()"
					style="text-decoration: none; font-family: 'Droid Sans'; color: white">
					<img src="<c:url value="/resources/img/logout.png"/>" />Logout
				</a>
			</div>
			<div class=Messagesimg>
				0 <img src="<c:url value="/resources/img/messages.gif"/>" />
			</div>
			<div class=Rssimg>
				<img src="<c:url value="/resources/img/rss.png"/>" />
			</div>
			<div class=Buddylistimg>

				<img src="<c:url value="/resources/img/buddylist.gif"/>" />
			</div>
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
				style="font-family: 'Droid Sans'; color: white">Home</a></li>
			<li><a href="http://localhost:8080/SpringMVCHibernate/airplane"
				style="font-family: 'Droid Sans'; color: white">Flights</a></li>
			<li><a href="http://localhost:8080/SpringMVCHibernate/airport"
				style="font-family: 'Droid Sans'; color: white">Airports</a></li>
			<li><a href="http://localhost:8080/SpringMVCHibernate/client"
				style="font-family: 'Droid Sans'; color: white">MyFlights</a></li>
			<li><a href="http://localhost:8080/SpringMVCHibernate/aboutus"
				style="font-family: 'Droid Sans'; color: white">AboutUs</a></li>

		</ul>
	</div>
	<div class=MainBody>
		<div class=MainBodyFirstBar>

			<div class=search style="position: relative; left: 80px; top: 60px">

				<input type="text" id="search" placeholder="Type to search">
				<!-- Table -->

				<table id="tableairplane" style="position: relative; left: -83px">
					<thead>
						<tr>
							<th>AirplaneID</th>
							<th>Aircraft Type</th>
							<th>Departure</th>
							<th>Arrival</th>
							<th>From</th>
							<th>To</th>
							<th>Delay</th>
							<!-- <th>Seats Remaining</th> -->
						</tr>
					</thead>
					<c:forEach var="row" items="${result.rows}">
						<tr id=trr>
							<td><c:out value="${row.airplane_id}" /></td>
							<td><c:out value="${row.aircrafttype}" /></td>
							<td><c:out value="${row.departure}" /></td>
							<td><c:out value="${row.arrival}" /></td>
							<td><c:out value="${row.fromm}" /></td>
							<td><c:out value="${row.too}" /></td>
							<td><c:out value="${row.delay}" /></td>
							<!--  <td><a href="<c:url value='/edit/${person.id}' />" >Edit</a></td>-->
							<td>
								<!--  <button onclick="myFunction(${row.airplane_id})">--> <a
								href="<c:url value='client/remove/${clientId}/${row.airplane_id}' />"
								style="text-decoration: none"
								onclick="myFunction(${row.airplane_id})">Remove</a>
							</td>
							<!--   <td><c:out value="${row.seats} - ${row.seatsr}"/></td>-->
					</c:forEach>
				</table>
			</div>
		</div>
	</div>




	<!-- SQL Abbrev -->

	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/lic" user="root" password="root" />
	<table class="abbrevTable"
		style="position: absolute; left: 1000px; top: 400px">
		<tr>
			<th>City</th>
			<th>Abbrev</th>
		</tr>

		<sql:query dataSource="${snapshot}" var="city">
SELECT * FROM abbrev
</sql:query>
		<c:forEach var="row" items="${city.rows}">
			<tr>
				<td><c:out value="${row.city}" /></td>
				<td><c:out value="${row.abbrev}" /></td>
			</tr>
		</c:forEach>
	</table>
	<!-- Security -->
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
	<!-- 
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>
	 -->
	<!-- Alert -->
	<script>
					function myFunction() {
						var string="The plane with Id " + arguments[0] +" has been removed";
					    alert(string);
					}
	</script>
	<script>
		var $rows = $('#tableairplane #trr');
		$('#search').keyup(function() {
		    var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase();

		    $rows.show().filter(function() {
		        var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
		        return !~text.indexOf(val);
		    }).hide();
		});
		</script>
</body>
</html>