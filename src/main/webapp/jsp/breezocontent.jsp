<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content">
    <c:choose>
    <c:when test="${datavalid == true}" >
    <table id="Air Quality" class="display" cellspacing="0" width="80%">
        <tbody>
        <tr><td><h2>Air Quality          </h2></td></tr>
        <tr><td><h4>Country              </h4></td> <td>${country}              </td></tr>
        <tr><td><h4>Breezo Description   </h4></td> <td>${breezedescription}    </td></tr>
        <tr><td><h4>Pollutant            </h4></td> <td>${pollutant}            </td></tr>
        <tr><td><h4>Pollutant Description</h4></td> <td>${pollutiondescription} </td></tr>
        <tr><td><h4>Causes               </h4></td> <td>${causes}               </td></tr>
        <tr><td><h4>Effects              </h4></td> <td>${effects}              </td></tr>
        <tr><td><h4>Main                 </h4></td> <td>${main}                 </td></tr>
        <tr><td><h3>Recommendations:     </h3></td></tr>
        <tr><td><h4>Children             </h4></td> <td>${children}             </td></tr>
        <tr><td><h4>Health               </h4></td> <td>${health}               </td></tr>
        <tr><td><h4>Inside               </h4></td> <td>${inside}               </td></tr>
        <tr><td><h4>Outside              </h4></td> <td>${outside}              </td></tr>
        <tr><td><h4>Sport                </h4></td> <td>${sport}                </td></tr>
        </tbody>
    </table>
    </c:when>
    </c:choose>
</div>