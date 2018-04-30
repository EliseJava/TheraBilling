<header>
    <h1>TheraBilling</h1>

    <form id="signout" action="logOut" method="get" >
        <input type="submit" value="Sign Out">
        <br><br>
        <a href="https://www.latlong.net/">Lat/Long</a>
    </form>

    <br>
    <a href="dashboard.jsp">LOGIN</a>

    <form id="breezoResponse" action="breezoResponse" method="get" >
        BreezoMeter lat <input type="text" name="lat"  value="43.073052"   required>
        long<input type="text" name="long" value="-89.401230"  required>
        <input type="submit" value="GO">
        <p style="color:red">${error}</p>
    </form>

</header>