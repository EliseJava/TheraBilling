<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<c:set var="title" value="Patient Database" />
<%@include file="head.jsp"%>
<c:import url="head-tag.jsp" />
<c:import url="java-script-table.jsp" />

<body>
<c:import url="header-tag.jsp" />
<p><a href="dashboard.jsp">Go Back</a></p>

<div style="float:left; width:50%;">
    <form action="patientMaintenance" method="GET">
        <br>
        First Name: <input type="text" name="firstname" required>
        Last Name : <input type="text" name="lastname" required>
        <input type="submit" name="add" value="Add a new Patient">
        <br>
    </form>
</div>
<div style="float:left; width:50%;">
    <form action ="patientUpdateDelete" method="GET">
        <br>
        Id: <input type="number" name="id" required>
        <input type="submit" name="update" value="Change/Add Appointments">
        <input type="submit" name="delete" value="Delete">
        <br>
    </form>
</div>

<div style="float:left; width:100%;">
    <br>
</div>

<div class="container-fluid">
    <h2>Patients</h2>
    <table id="patientTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>Id            </th>
        <th>First Name    </th>
        <th>Last Name     </th>
        <th>Diagnosis     </th>
        <th>Referred by   </th>
        <th>Street        </th>
        <th>City          </th>
        <th>State         </th>
        <th>Postal_Code   </th>
        <th>Procedure Code/Appointments</th>

        </thead>
        <tbody>
        <c:forEach var="patient" items="${patients}">
            <tr>
                <td>${patient.id}</td>
                <td>${patient.firstName}</td>
                <td>${patient.lastName}</td>
                <td>${patient.diagnosis}</td>
                <td>${patient.referredBy}</td>
                <td>${patient.streetName}</td>
                <td>${patient.city}</td>
                <td>${patient.state}</td>
                <td>${patient.postalCode}</td>
                <td>
                    <c:forEach var="procedure" items="${patient.treatmentPlan}">
                        <ol ul style="list-style-type:square">
                            <c:if test="${procedure.billingStatusActive == true}">
                                <li style="color: #036DA7"> ${procedure.appointmentDate} / ${procedure.procedureCode.code} / ${procedure.procedureCode.description} </li>
                            </c:if>
                            <c:if test="${procedure.billingStatusActive == false}">
                                <li> ${procedure.appointmentDate} / ${procedure.procedureCode.code} / ${procedure.procedureCode.description} </li>
                            </c:if>
                        </ol>

                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
<c:import url="footer.jsp" />
</html>



