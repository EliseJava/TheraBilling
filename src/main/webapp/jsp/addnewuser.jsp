<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<c:import url="head-tag.jsp" />
<c:set var="title" value="Log in" />

<body>
<c:import url="header-tag.jsp" />
<p><a href="dashboard.jsp">Go Back</a></p>
<c:import url="menu-tag.jsp" />

<div id="content" style="float:left; width:25%;">
    <form action="userAdd" method="GET">
        <br>
        First Name<br><input type="text" name="FirstName" required>
        <br><br>
        Last Name<br><input type="text" name="LastName" required>
        <br><br>
        User Name<br><input type="text" name="userName" required>
        <br><br>
        Role<br><input type="text" name="role" value="receptionist">
        <br><br>
        <input type="submit" value="Add User" name="useradd">
    </form>
</div>
<div id="content" style="float:right; width:40%;">
    Registered Users
    <br>
    <c:forEach var="user" items="${users}">
        <ol ul style="list-style-type:square">
            <li> ${user.firstName} ${user.lastName} / ${user.userName} </li>
        </ol>

    </c:forEach>
</div>

<c:import url="footer.jsp" />
</body>
</html>
