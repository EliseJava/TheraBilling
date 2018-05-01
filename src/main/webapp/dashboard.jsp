<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<c:import url="jsp/head-tag.jsp" />

<body>
<div id="wrap">
	<c:import url="jsp/header-tag.jsp" />
        <div style="float:left; width:90%;">
            <a href="index.jsp">Home</a>
        </div>
        <div style="float:left; width:10%;">
            <a href="userAdd">Add new user</a>
        </div>

    <c:import url="jsp/dashcontent.jsp" />
</div>
	<c:import url="jsp/footer.jsp" />
</body>
</html>

