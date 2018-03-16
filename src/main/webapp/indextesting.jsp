<!doctype html>    
<html lang="en">
    
<head>
    <meta charset="utf-8">
    <title>TheraBilling</title>
    <link rel="stylesheet" href="css/theraStyle.css">
</head>


	
<body>
	<main><H1>TheraBilling</H1></main>
	
	<!-- Change to( form action="/(referenceURL)"> ) When you want to actually use a stored password
		For now submit will just link to the second page regardless of input --!>
	<!-- Also the input type on line 28 will need to be changed from "button" to "submit" -->
		
	<form>
		Username: <input type="text" name="uname"><br>
		Password: <input type="password" name="pass"><br>
		<a href="index2_dashboard.html#"><input type="button" value="Submit"></a>
	</form>
	<br>

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
	
	<!-- Google Calendar Embed (Easy to change) -->
	<iframe class="calendar" src="https://calendar.google.com/calendar/embed?title=%20%20%20&amp;showTitle=0&amp;showPrint=0&amp;showCalendars=0&amp;height=300&amp;wkst=1&amp;bgcolor=%23FFFFFF&amp;ctz=America%2FChicago" style="border-width:0" width="400" height="300" frameborder="0" scrolling="no"></iframe>
	
</body>

<footer>
	<!-- Anything that you want in the footer goes here (Social Media, Sponsors, etc. -->
</footer>