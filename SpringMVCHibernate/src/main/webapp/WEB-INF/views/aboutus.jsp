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
 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--  
 <script type="text/javascript">
        function codeAddress() {
            alert('ok');
        }
        window.onload = drawChart(1,2,3,4,5,6);
   </script>
   -->
<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
		
        var data = google.visualization.arrayToDataTable([
         ['Airplaneid',           'seats'],
          ['${airplane_id}',     ${seatsr}],
          ['${airplane_idd}',      ${seatsrr}],
          ['${airplane_iddd}',  ${seatsrrr}]
          ]);

        var options = {
          fontSize:12,
          fontName:'Droid Sans',
          width: 400,
          height: 200,
          
          backgroundColor: '#0080FF',
          is3D: true
        	          
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
      
    </script>

	
<title>Aboutus</title>
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
div.Charts{
	position:relative;
	left:50px;
	top:20px;
	}
div.PopularFlights{
	position:relative;
	top:10px;
	color:white;
	font-family: 'Droid Sans';
	font-size:140%;
}
div.ContactUs{
    position:relative;
    left:630px;
	top:-215px;
	color:white;
	font-family: 'Droid Sans';
	font-size:140%;

}
</style>
</head>
<body>

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
	
	<hr width="9px" size="393px" style="position:absolute;border-bottom-left-radius: 25px;
border-bottom-right-radius: 25px;background-color:#5858FA;left:600px"/>
		<div class=MainBodyFirstBar>
		<div class=PopularFlights>
		  Popular Flights
		</div>
		<div class=Charts>
			<div id="piechart"></div>
			</div>
			<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/lic" user="root" password="root" />
	   <table class="abbrevTable"
		style="position: absolute; left: 50px; top: 220px">
		<tr>
			<th>AirplaneId</th>
			<th>Aircrafttype</th>
			<th>From</th>
			<th>To</th>
			<th>Seat</th>
		</tr>

		<sql:query dataSource="${snapshot}" var="airplane">
SELECT * FROM airplane
</sql:query>
		<c:forEach var="row" items="${airplane.rows}">
			<tr>
				<td><c:out value="${row.airplane_id}" /></td>
				<td><c:out value="${row.aircrafttype}" /></td>
				<td><c:out value="${row.fromm}" /></td>
				<td><c:out value="${row.too}" /></td>
				<td><c:out value="${row.seatsr}" /></td>
			</tr>
		</c:forEach>
	</table>
	<div class=ContactUs>
	Contact Us
	<br>
	<br>
	<br>
	<div class=Email style="position: relative;left:-80px">
	Email:www.email@email.org
	</div>
	<br>
	 Phone:0909090909
	</div>
		</div>
	</div>



	
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
			var string = "The plane with Id " + arguments[0]
					+ " has been removed";
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