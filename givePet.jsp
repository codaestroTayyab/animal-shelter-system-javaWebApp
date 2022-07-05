<html>
    <title>
        Give Pet
    </title>
    <head>
        <link rel="stylesheet" href="loginPage.css">
        <script type="text/javascript" src=""></script>
    </head>
    <body>
    <%
        String email = (String)session.getAttribute("email");
        
        if(email == null)
        {
    %>
        <center>
        <p>You're not Logged in. Kindly Login!</p>
        </center>
        <jsp:include page = "loginPage.html"/>
    <%
        }
        else
        {
    %>
        <div class="sign">
            <h3>
               <center>Give Pet</center>
            </h3>
            <form name = "givePet" action="givePet" method="post">
                <div class="entries">
                    <input type="number" name="petID" id = "pid"placeholder="Enter Pet ID to give that pet" required style="width: 92%;">
                    <br><br>
                    
                    <center><button type="submit">Give Pet</button></center>
                </div>
            </form>
            <br><br><br><br><br><br>
            <jsp:include page = "backToMain.html"/>
        </div>
    <%
        }
    %>
    </body>
</html>