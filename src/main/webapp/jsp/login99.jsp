<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta charset="utf-8">
<c:import url="/jsp/wesite-title-tag.jsp" />
<link rel="stylesheet" type="text/css" href="css/theraStyle.css?version=51">

</head>

<body>
<header>
<h1>TheraBilling</h1>

<form id="signout" action="logOut" method="get" >
<input type="submit" value="Sign Out">
</form>

<br>
<a href="dashboard.jsp">LOGIN</a>

<form id="breezoResponse" action="breezoResponse" method="get" >
BreezoMeter lat <input type="text" name="lat"  value="43.073052"   required>
long<input type="text" name="long" value="-89.401230"  required>
<input type="submit" value="GO">
<br>
</form>

</header>

<div id="sidebar">
<nav>
<ul>
<li><a href="services/letters">Patient Letters</a></li>
<li><a href="https://www.latlong.net/">Lat/Long Finder</a></li>
<li><a href="https://greatist.com/health/ultimate-guide-good-posture">Posture</a></li>
</ul>
</nav>

</div>

<div id="login">
<form action="j_security_check" method="POST">
User Name:<input type="TEXT" name="j_username"><br><br>
Password :<input type="PASSWORD" name="j_password"><br><br>
<input type="submit" value="submit">
</form>
</div>
<br><br>

<footer>
THIS IS THE FOOTER
<form action="patientsShowAll" >
<input type="submit" value="bypass login for testing">
</form>
</footer>
</body>

</html>
