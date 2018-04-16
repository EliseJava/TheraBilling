<header>
    <h1>TheraBilling</h1>

    <a href="dashboard.jsp">LOGIN</a>

    <form action="logOut" method="get" >
        <input type="submit" value="Sign Out">
    </form>
    <br>
    <br>
    <form action="breezoResponse" method="get" >
        BreezoMeter lat <input type="text" name="lat"  value="43.073052"   required>
                    long<input type="text" name="long" value="-89.401230"  required>
        <input type="submit" value="GO">
        <br>${error}
    </form>

</header>
