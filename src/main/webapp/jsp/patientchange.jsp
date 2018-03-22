<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<c:set var="title" value="Patient Change" />
<%@include file="head.jsp"%>
<c:import url="head-tag.jsp" />

<body>
<c:import url="header-tag.jsp" />

<form action="patientChange" method="GET">
    <br>First Name
    <br><input type="text" name="chgFirstName" value='${patient.firstName}'>
    <br>Last Name
    <br><input type="text" name="chgLastName" value='${patient.lastName}'>
    <br>Diagnosis
    <br><input type="text" name="chgDiagnosis" value='${patient.diagnosis}'>
    <br>Referred by
    <br><input type="text" name="chgRefferedBy" value='${patient.referredBy}'>
    <br>Street Name
    <br><input type="text" name="chgStreet" value='${patient.streetName}'>
    <br>City
    <br><input type="text" name="chgCity" value='${patient.city}'>
    <br>State
    <br><input type="text" name="chgState" value=${patient.state}>
    <br>Postal Code
    <br><input type="number" name="chgCode" value=${patient.postalCode}>
    <br><br>
    <br><input type="submit" value="Change">
    <td>
        <c:forEach var="procedure" items="${patient.treatmentPlan}">
            <ol ul style="list-style-type:square">
                <li>  code: ${procedure.procedureCode} date: ${procedure.appointmentDate} </li>
            </ol>

        </c:forEach>
    </td>
</form>

<tr>
    <form method="post" action="">
        <td>
            ${diagnosis}
        </td>

        <td>
            <input type="text" name="desc" value=${patient.firstName}>
        </td>
    </form>
</tr>

</body>
<c:import url="footer.jsp" />
</html>