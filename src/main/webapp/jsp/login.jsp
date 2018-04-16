<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<c:import url="head-tag.jsp" />
<c:set var="title" value="Log in" />

<body>
<c:import url="header-tag.jsp" />
<c:import url="menu-tag.jsp" />

    <form action="j_security_check" method="POST">
        <br>
        User Name:<input type="TEXT" name="j_username"><br><br>
        Password :<input type="PASSWORD" name="j_password"><input type="submit" value="submit">
    </form>

<c:import url="footer.jsp" />
</body>

</html>
