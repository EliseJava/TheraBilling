<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<c:set var="title" value="Patient Database" />
<%@include file="head.jsp"%>

<body>

<c:forEach var="billings" items="${billing}">
    <H4>Billing Statement from TheraBilling</H4>
    <c:set var="total" value="0.00"/>
    <section>
            ${billings.firstName}  ${billings.lastName}
        <br>${billings.streetName}
        <br>${billings.city}
        <br>${billings.state}
        <br>${billings.postalCode}
    </section>

    <br>

    <p>
        Diagnosis: ${billings.diagnosis}
    </p>

<table cellspacing="0" width="70%">
    <th>Procedure Code</th>
    <th>Description</th>
    <th>Billed Amount</th>
    <c:forEach var="proc" items="${billings.treatmentPlan}">
            <tr>
                <td>${proc.procedureCode.code}</td>
                <td>${proc.procedureCode.description}</td>
                <td>${proc.procedureCode.unitPrice}</td>
            </tr>
            <c:set var="total" value="${total + proc.procedureCode.unitPrice}"/>

    </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td>____________</td>
            </tr>
            <tr>
                <td></td>
                <td>TOTAL</td>
                <td>$${total}</td>
            </tr>
</table>

    <br>-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

</c:forEach>
<br>
</body>


