<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<c:set var="title" value="Billing Statements" />
<%@include file="head.jsp"%>

<p>

<c:set var="grosstotal" value="0.00"/>
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
    <th>Procedure Date</th>
    <th>Procedure Code</th>
    <th>Description</th>
    <th>Billed Amount</th>
    <c:forEach var="proc" items="${billings.treatmentPlan}">
            <tr>
                <td>${proc.appointmentDate}</td>
                <td>${proc.procedureCode.code}</td>
                <td>${proc.procedureCode.description}</td>
                <td><fmt:setLocale value = "en_US"/>
                    <fmt:formatNumber value = "${proc.procedureCode.unitPrice}" type = "currency"/></td>

            </tr>
            <c:set var="total" value="${total + proc.procedureCode.unitPrice}"/>

    </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td>____________</td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td>TOTAL</td>
                <td><fmt:setLocale value = "en_US"/>
                    <fmt:formatNumber value = "${total}" type="currency"/></td>

                <c:set var="grosstotal" value="${grosstotal + total}"/>
            </tr>
    </table>

    <br>----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

</c:forEach>

<br>
<br>
<br>

<p> <h3>Monthly Gross Income:
    <fmt:setLocale value = "en_US"/>
    <fmt:formatNumber value = "${grosstotal}" type = "currency"/></h3>
</p>

</body>
</html>

