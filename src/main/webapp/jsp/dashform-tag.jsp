<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="es" uri="http://matc.edu/tags"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<c:import url="/jsp/head-tag.jsp" />

<body>
<div id="wrap">
    <c:import url="/jsp/header-tag.jsp" />
        <form>
            <fieldset>
                <legend>Word of the day</legend>
                <h2><es:Hello/></h2>
            </fieldset>
        </form>
    <c:import url="/jsp/menu-tag.jsp" />
    <c:import url="/jsp/footer.jsp" />
</body>
</html>

