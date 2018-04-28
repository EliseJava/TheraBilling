<div id="login">

    <form action="j_security_check" method="POST">
        User Name:<input type="TEXT" name="j_username"><br><br>
        Password :<input type="PASSWORD" name="j_password"><br><br>
        <input type="submit" value="submit">
        <br>
    </form>
    <br><br>
    <button onclick="myFunction()">Forgot password?</button>

    <p id="demo"></p>
    <script>
        function myFunction() {
            document.getElementById("demo").innerHTML = "Call your administrator 1 888 654-5000";
        }
    </script>
</div>