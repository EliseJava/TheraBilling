<%@include file="/jsp/head.jsp"%>
<html>

<head>
    <meta charset="utf-8">
    <title>TheraBilling</title>
    <link rel="stylesheet" href="theraStyle.css">
</head>
<body>

<main><H1>TheraBilling</H1></main>

<h2>Search for Patients</h2>

<form action="searchUser" method="GET">
    <input type="submit" value="View all Patients or enter Last Name"><br><br>
    Search Last Name:<input type="text" name="searchName">
</form>

</body>
</html>