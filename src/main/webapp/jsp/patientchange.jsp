<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<c:set var="title" value="Patient Change" />
<%@include file="head.jsp"%>
<c:import url="head-tag.jsp" />

<body>
<c:import url="header-tag.jsp" />


<div style="float:left; width:25%;">
    <form action="patientChange" method="GET">
        <br>First Name
        <br><input type="text" name="chgFirstName" value='${patient.firstName}' required>
        <br><br>Last Name
        <br><input type="text" name="chgLastName" value='${patient.lastName}' required>
        <br><br>Diagnosis
        <br><input type="text" name="chgDiagnosis" value='${patient.diagnosis}' required>
        <br><br>Referred by
        <br><input type="text" name="chgReferredBy" value='${patient.referredBy}' required>
        <br><br>Street Name
        <br><input type="text" name="chgStreet" value='${patient.streetName}' required>
        <br><br>City
        <br><input type="text" name="chgCity" value='${patient.city}' required>
        <br><br>State
        <br><input type="text" name="chgState" value='${patient.state}' required>
        <br><br>Postal Code
        <br><input type="number" name="chgCode" value='${patient.postalCode}' required>
        <br>
        <br><input type="submit" name="ChgPatient" value="Change Patient information">
    </form>
</div>

<div style="float:left; width:25%;">
    <form action="patientAddAppointment" method="GET">
        <br>Procedure code
        <br><input type="number"         name="addProcCode">
        <br><br>Appointment date
        <br><input type="datetime-local" name="addAppointmentDate">
        <br><br>
        <input type="submit"   name="addNewAppointment" value="Add an appointment">
    </form>
</div>

<div style="float:left; width:50%;">
            <br>Procedure code..............Appointment date<br>
        <c:forEach var="procedure" items="${patient.treatmentPlan}">
        <form action="appointmentChangeDel" method="GET">
            <br>
            <input type="hidden"         name="AppointId"   value=${procedure.id}>
            <input type="number"         name="ProcCode" value=${procedure.procedureCode}>
            <input type="datetime-local" name="AppointDate" value=${procedure.appointmentDate}>
            <input type="submit" name="change" value="Change">
            <input type="submit" name="delete" value="Delete">
            <br>
        </form>

        </c:forEach>
</div>

<div style="float:left; width:100%;">
    <br>
</div>

</body>
</html>