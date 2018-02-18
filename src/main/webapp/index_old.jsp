<%@taglib prefix="es" uri="http://matc.edu/tags"%>
<html>
<body>
<form>
    <fieldset>
        <legend>Custom Tag</legend>
        <h2><es:Hello/></h2>
    </fieldset>
</form>

<form action="loginPage" method="GET">
    <input type="submit" value="View all users or enter Last Name"><br><br>
    User Name:<input type="text" name="userName">
</form>
</body>
</html>
