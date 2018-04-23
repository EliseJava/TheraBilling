<!--  I don't know how to use jsp files, here's the second page

I also don't understand how the header imports over
-->

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta charset="utf-8">
	<c:import url="/jsp/wesite-title-tag.jsp" />
	<link rel="stylesheet" type="text/css" href="css/theraStyle.css?version=51">
</head>

<body>
<div id="wrap">
<header>
<h1>TheraBilling</h1>

<a href="dashboard.jsp">LOGIN</a>

	<form action="logOut" method="get" >
	<input type="submit" value="Sign Out">
	</form>
<br>
<br>
	<form id="breezoResponse" action="breezoResponse" method="get" >
		BreezoMeter lat <input type="text" name="lat"  value="43.073052"   required>
		long<input type="text" name="long" value="-89.401230"  required>
		<input type="submit" value="GO">
		<br>
	</form>

</header>

<!-- GRID for buttons -->
<div class="section">
	<div class="col grid_1_of_4">
		<div id="sidebar">
			<nav>
				<ul>
					<li><a href="services/letters">Patient Letters</a></li>
					<li><a href="https://www.latlong.net/">Lat/Long Finder</a></li>
					<li><a href="https://greatist.com/health/ultimate-guide-good-posture">Posture</a></li>
				</ul>
			</nav>
		</div>
	</div>
	<div class="col grid_1_of_4"> <a href="dailySchedule" class="button"><span>Daily Schedule</span></a> <a href="patientsShowAll" class="button"><span>Patient Information</span></a></div>
	<div class="col grid_1_of_4"> <a href="#" class="button"><span>Treatment Plans</span></a> <a href="monthlyBilling" class="button"><span>Billing </span></a></div>
	<div class="col grid_1_of_4"></div>
</div>
</div>

<footer>
	THIS IS THE FOOTER
	<form action="patientsShowAll" >
		<input type="submit" value="bypass login for testing">
	</form>
</footer>
</body>

</html>




