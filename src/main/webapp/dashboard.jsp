<!doctype html>    
<html lang="en">
    
<head>
    <meta charset="utf-8">
    <title>TheraBilling Dashboard</title>
    <link rel="stylesheet" href="css/theraStyle.css">
</head>

<header>
	<!-- The header should be the same between all pages (probably) -->
	<p><a href="google.com">Google</a>
	<a href="https://www.w3schools.com/html/default.asp">HTML Documentation</a>
	
	</p>
</header>

<body>
	<main><H1>TheraBilling</H1></main>
	<br>
	
	<!-- buttons have # as a placeholder (that links to the second page) -->
	<!-- Font for button -->
	<link href='http://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>

	<nav>		
		<a href="#" class="button"><span>Daily Schedule</span></a>
		<a href="#" class="button"><span>Treatment Plans</span></a>
		<a href="#" class="button"><span>Patient Information</span></a>
		<form action="patientsShowAll" >
			<input type="submit" value="get">
		</form>

		<a href="#" class="button"><span>Billing</span></a>
		
	</nav>
	
	<!-- Google Calendar Embed (Easy to change) -->
	<iframe class="calendar" src="https://calendar.google.com/calendar/embed?title=%20%20%20&amp;showTitle=0&amp;showPrint=0&amp;showCalendars=0&amp;height=300&amp;wkst=1&amp;bgcolor=%23FFFFFF&amp;ctz=America%2FChicago" style="border-width:0" width="400" height="300" frameborder="0" scrolling="no"></iframe>
	
</body>

<footer>
	<!-- Anything that you want in the footer goes here (Social Media, Sponsors, etc. -->
	<!-- The footer should be the same between all pages (probably), maybe add a disclosure where necessary -->
</footer>