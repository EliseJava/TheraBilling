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


<form action="/patientMaintenance" method="GET">

    <br>First Name
    <br><input type="text" name="addFirstName"><br>
    <br>Last Name
    <br><input type="text" name="addLastName"><br>
    <br>SSN
    <br><input type="text" name="addSSN"><br>
    <br>Department
    <br><input type="text" name="addDept"><br>
    <br>Room Number
    <br><input type="text" name="addRoom"><br>
    <br>Phone Number
    <br><input type="text" name="addPhone"><br>

    <br><br>
    <input type="submit" name="addpatient" value="AddPatient">
</form>
<p><a href="/patientsShowAll">Back to Patients</a></p>

</body>
</html>