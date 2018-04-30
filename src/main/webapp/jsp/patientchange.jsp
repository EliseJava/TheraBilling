<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<c:set var="title" value="Patient Change" />
<%@include file="head.jsp"%>
<c:import url="head-tag.jsp" />

<body>
<c:import url="header-tag.jsp" />
<p><a href="dashboard.jsp">Go Back</a></p>

<div style="float:left; width:20%;">
    <form action="patientChange" method="GET">
        <br>
        <h4>Change Patient information</h4>
        <br>
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

<div style="float:left; width:30%;">
    <form action="patientAddAppointment" method="GET">
        <br>
        <h4>Add an appointment</h4>
        <br><br>
        <fieldset>
             <p>
                <label>Procedure code</label>
                <select id = "myList" name="addProcCode">
                    <option value = 97001>97001 Physical Therapy Evaluation</option>
                    <option value = 97010>97010 Hot or Cold Packs</option>
                    <option value = 97012>97012 Mechanical Traction</option>
                    <option value = 97014>97014 Electrical Stimulation</option>
                    <option value = 97018>97018 Paraffin bath</option>
                    <option value = 97026>97026 Infrared</option>
                    <option value = 97028>97028 Ultraviolet</option>
                    <option value = 97035>97035 Ultrasound</option>
                    <option value = 97110>97110 Therapeutic Exercise</option>
                    <option value = 97124>97124 Massage Therapeutic</option>
                    <option value = 97140>97140 Manual Therapy Techniques</option>
                    <option value = 97535>97535 Self Care / Home Management</option>
                </select>
            </p>
        </fieldset>

        Appointment date
        <br><input type="datetime-local" name="addAppointmentDate" required>
        <br><br>
        <input type="submit"   name="addNewAppointment" value="Add an appointment">
    </form>
</div>

<div style="float:left; width:50%;">
    <br>
    <h4>Change or Delete an appointment</h4>
        <br>
        <c:forEach var="procedure" items="${patient.treatmentPlan}">
        <c:if test="${procedure.billingStatusActive == false}">
        <form action="appointmentChangeDel" method="GET">
            <input type="hidden"         name="AppointId"   value=${procedure.id}>
            <br>
                    ${procedure.procedureCode.code}
                    <label>Proc code</label>
                    <select id="ProcCode" name="ProcCode" >
                        <option value = 97001>97001</option>
                        <option value = 97010>97010</option>
                        <option value = 97012>97012</option>
                        <option value = 97014>97014</option>
                        <option value = 97018>97018</option>
                        <option value = 97026>97026</option>
                        <option value = 97028>97028</option>
                        <option value = 97035>97035</option>
                        <option value = 97110>97110</option>
                        <option value = 97124>97124</option>
                        <option value = 97140>97140</option>
                        <option value = 97535>97535</option>
                    </select>


                    <input type="datetime-local" name="AppointDate" value=${procedure.appointmentDate}>
                    <input type="submit" name="change" value="Change">
                    <input type="submit" name="delete" value="Delete">
            <br>
                    </form>
        </c:if>
        </c:forEach>
</div>

<div style="float:left; width:100%;">
    <br>
</div>

</body>
</html>