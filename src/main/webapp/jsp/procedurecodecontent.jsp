<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- GRID for buttons -->
<div class="section">

    <div class="col grid_1_of_4">
        <c:import url="/jsp/menu-tag.jsp" />
    </div>

    <div id="content">
        <table id="Codes" class="display" cellspacing="0" width="100%">

            <th>Procedure Code  </th>
            <th>Description     </th>

            <c:forEach var="code" items="${codes}">

                <tr>
                    <td>${code.code}</td>
                    <td>${code.description}</td
                </tr>

            </c:forEach>
        </table>
    </div>
</div>