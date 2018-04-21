<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<c:set var="title" value="Patient Database" />
<%@include file="head.jsp"%>
<c:import url="head-tag.jsp" />
<c:import url="java-script-table-schedule.jsp" />

<body>
<c:import url="header-tag.jsp" />


<div class="container-fluid">
    <h2>Patients</h2>
    <table id="scheduleTable" class="display" cellspacing="0" width="80%">
        <thead>
        <th>Patient First Name</th>
        <th>Patient Last Name</th>
        <th>Procedure     </th>
        <th>Appointment   </th>
        </thead>
        <tbody>
        <c:forEach var="items" items="${schedule}">
            <tr>
                    <td>${items.patient.getFirstName()}</td>
                    <td>${items.patient.getLastName()}</td>
                    <td>${items.procedureCode}</td>
                    <td>${items.appointmentDate}</td>
                    <td><form action="dailySchedule" method="GET">
                        <input type="hidden" name="AppointId" value=${items.id}>
                        <input type="submit" name="checkout"  value="CHECKOUT">
                        </form>
                    </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
<c:import url="footer.jsp" />
</html>



