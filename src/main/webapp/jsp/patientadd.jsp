<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<c:set var="title" value="Patient Add" />
<%@include file="head.jsp"%>
<c:import url="head-tag.jsp" />


<body>
<c:import url="header-tag.jsp" />

<form action="patientAdd" method="GET">
    <br>First Name<input type="text" name="addFirstName" value=${firstname}>  Last Name<input type="text" name="addLastName" value=${lastname}>
    <br>
    <br>Diagnosis
    <br><input type="text" name="addDiagnosis" autofocus="autofocus" required>  Evaluation Appointment Date: <input type="datetime-local" name="addAppointment" required><br>
    <br>Referred by
    <br><input type="text" name="addRefferedBy" required><br>
    <br>Street Name
    <br><input type="text" name="addStreet" required><br>
    <br>City
    <br><input type="text" name="addCity" required><br>
    <br>State
    <br><input type="text" name="addState" required><br>
    <br>Postal Code
    <br><input type="number" name="addCode" required><br>
    <br><br>

    <input type="submit" value="Add Patient">
</form>

</body>
<c:import url="footer.jsp" />
</html>