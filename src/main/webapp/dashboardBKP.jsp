<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<c:import url="jsp/head-tag.jsp" />

<body>
<c:import url="jsp/header-tag.jsp" />

		<div style="float:left; width:50%;">

			<a href="dailySchedule" class="button"><span>Daily Schedule</span></a>
			<br>
			<a href="#" class="button"><span>Procedure Codes</span></a>
		</div>

		<div style="float:left; width:50%;">
			<a href="patientsShowAll" class="button"><span>Patient Information</span></a>
			<br>
			<a href="#" class="button"><span>Billing</span></a>
		</div>

		<br><br><br>
	
<c:import url="jsp/footer.jsp" />
</body>
