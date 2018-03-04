<%@taglib prefix="es" uri="http://matc.edu/tags"%>
<html>
<head>
    <meta charset="utf-8">
    <title>TheraBilling</title>
    <link rel="stylesheet" href="theraStyle.css">
</head>
<body>
<form>
    <fieldset>
        <legend>Word of the day</legend>
        <h2><es:Hello/></h2>
    </fieldset>
</form>


<form action="j_security_check" method="POST">
        <br>
        User Name:<input type="TEXT" name="j_username"><br><br>
        Password :<input type="PASSWORD" name="j_password"><input type="submit" value="submit">
</form>

</body>
</html>
