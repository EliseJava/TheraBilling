<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<c:set var="title" value="Billing Statements" />
<%@include file="head.jsp"%>



<c:set var="grosstotal" value="0.00"/>
<c:forEach var="monthbill" items="${mbilling}">
    <H4>Billing Statement from TheraBilling</H4>
    <c:set var="total" value="0.00"/>
    <section>
            ${monthbill.firstName}  ${monthbill.lastName}
        <br>${monthbill.streetName}
        <br>${monthbill.city}
        <br>${monthbill.state}
        <br>${monthbill.postalCode}
    </section>
    <br>
    <p>
        Diagnosis: ${monthbill.diagnosis}
    </p>

    <table cellspacing="0" width="70%">
    <th>Procedure Date</th>
    <th>Procedure Code</th>
    <th>Description</th>
    <th>Billed Amount</th>
        
        ${monthbill.treatmentPlan.size()}
    <c:forEach var="bproc" items="${monthbill.treatmentPlan}">
            <tr>
                <td>${bproc.appointmentDate}</td>
                <td>${bproc.procedureCode.code}</td>
                <td>${bproc.procedureCode.description}</td>
                <td><fmt:setLocale value = "en_US"/>
                    <fmt:formatNumber value = "${bproc.procedureCode.unitPrice}" type = "currency"/></td>

            </tr>
            <c:set var="total" value="${total + bproc.procedureCode.unitPrice}"/>

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

