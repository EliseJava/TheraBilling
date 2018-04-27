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

        <form id="signout" action="logOut" method="get" >
            <input type="submit" value="Sign Out">
        </form>

        <br>
        <a href="dashboard.jsp">LOGIN</a>



        <form id="breezoResponse" action="breezoResponse" method="get" >
            BreezoMeter lat <input type="text" name="lat"  value="43.073052"   required>
            long<input type="text" name="long" value="-89.401230"  required>
            <input type="submit" value="GO">
            <br>${error}
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

    <div id="content">

        <br>
        <div><pre><h2>
	Mrs. Robijn and partner has over 20 years of experience in the
	Physical Therapy business.

	We specialize in Sports Injuries

	Contact us to make an appointment:  (012) 693-1073

	Office hours: M-F 7:30am - 5:30pm

	Saturday appointments is available on special request

	Physicians approval letter is required</h2>
</pre></div>
        <br>

    </div>

    <footer>
        THIS IS THE FOOTER
        <form action="patientsShowAll" >
            <input type="submit" value="bypass login for testing">
        </form>
    </footer>

</div>
</body>

</html>
