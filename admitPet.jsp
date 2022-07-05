
<html>
    <title>
        Admit Pet
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
               <center>Admit Pet</center>
            </h3>
            <form action="admitPet" method="post">
                <div class="entries">
                    <input type="text" name="petName" placeholder="Enter Pet Name" required style="width: 92%;"><br><br>
                    <input type="text" name="petType" placeholder="Enter Pet Type" required style="width: 92%;" ><br><br>
                    </p>
                    Enter Date of Submission: <input type="date" name="dos" required><br><br>
                    <input type="number" name="age" placeholder="Enter Pet Age" required style="width: 92%" ><br><br>

                    <center><button type="submit">Submit</button></center>
                </div>
            </form>
            <br><br><br>
            <jsp:include page = "backToMain.html"/>
        </div>
    <%
        }
    %>
    </body>
</html>