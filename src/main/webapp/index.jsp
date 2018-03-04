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
<main><H1>TheraBilling</H1></main>

<%out.println("Your IP address is " + request.getRemoteAddr());%>

<c:import url="jsp/date.jsp" />

<form action="patientsShowAll" >
    <input type="submit" value="bypass login">
</form>

<p>Please input a number between 1 and 10:</p>
<input id="numb">
<button type="button" onclick="myFunction()">Submit</button>
<p id="demo"></p>
<script>
    function myFunction() {
        var x, text;

        // Get the value of the input field with id="numb"
        x = document.getElementById("numb").value;

        // If x is Not a Number or less than one or greater than 10
        if (isNaN(x) || x < 1 || x > 10) {
            text = "Input not valid";
        } else {
            text = "Input OK";
        }
        document.getElementById("demo").innerHTML = text;
    }
</script>

<form action="/action_page.php" method="post">
    <input type="text" name="fname" required>
    <input type="submit" value="Submit">
</form>


<div id="wrap">
    <a href="dashboard.jsp"/>login
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