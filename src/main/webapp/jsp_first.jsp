<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8">
    <title>TheraBilling</title>
    <link rel="stylesheet" href="css/theraStyle.css">
</head>

<c:set var="pageTitle" value="theraBilling" scope="request" />
<body>



<%out.println("Your IP address is " + request.getRemoteAddr());%>

<c:import url="jsp/date.jsp" />

<form action="patientsShowAll" >
    <input type="submit" value="bypass login">
</form>




<div id="wrap">
    <a href="dashboard.jsp"/> Click here to login
</div>
<br>
<br>
<div>
    Mrs. Robijn has over 20 years of experience in the Physical Therapy business. The
    specialize in Sports Injuries.

    Contact us to make an appointment:  693-1073
    Office hours: M-F 7:30am - 5:30pm
    Saturday appointments is available on special request

    Physicians approval letter is required
</div>

</body>
<footer>
    This is the footer   - goes here (Social Media, Sponsors, etc. -->
</footer>
</html>