<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#patientTable').DataTable();
    } );
</script>
<html>
<body>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <table id="patientTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>First Name    </th>
        <th>Last Name     </th>
        <th>Diagnosis     </th>
        <th>Referred by   </th>
        <th>Street        </th>
        <th>City          </th>
        <th>State         </th>
        <th>Postal_Code   </th>
        <th>Procedure Code</th>
        <th>Appointment date</th>

        </thead>
        <tbody>
        <c:forEach var="patient" items="${patients}">
            <tr>
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
                        ${procedure.id} ${procedure.procedureCode}
                        
                    </c:forEach>
                </td>
            </tr>


        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>