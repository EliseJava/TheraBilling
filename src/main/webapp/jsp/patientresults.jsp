<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>

<head>
    <meta charset="utf-8">
    <title>Patient database</title>
    <link rel="stylesheet" href="theraStyle.css">
</head>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#patientTable').DataTable();
    } );
</script>

<html>
<body>
<main><H1>TheraBilling</H1></main>

<form action="patientMaintenance" method="GET">


    <br><br>
    First Name: <input type="text" name="firstname" required>
    Last Name : <input type="text" name="lastname" required>
    <input type="submit" name="add" value="Add">
    <input type="submit" name="delete" value="Delete">
    <input type="submit" name="change" value="Change">
    <br>
</form>

<div class="container-fluid">
    <h2>Patients</h2>
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
        <th>Procedure Code/Appointment</th>


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
                        <ol ul style="list-style-type:square">
                            <li>  date: ${procedure.appointmentDate} ${procedure.procedureCode} </li>
                        </ol>
                        
                    </c:forEach>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>