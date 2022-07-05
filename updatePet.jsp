<html>
    <title>
        Update Pet
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
               <center>Update Pet Info</center>
            </h3>
            <form name = "updatePet" action="updatePet" method="post">
                <div class="entries">
                    <input type="number" name="petID" id = "pid"placeholder="Enter Pet ID *" required style="width: 92%;" required>
                    <br><br>
                    <input type="text" name="petName" id ="pName" placeholder="Update Name" style="width: 92%;"> <br><br>
                    <input type="text" name="petType" placeholder="Update Pet Type" style="width: 92%;"> <br><br>
                    <input type="date" name="dos" placeholder="Update Date of Submission" style="width: 92%;"> <br><br>
                    <input type="number" name="age" placeholder="Update Pet Age" style="width: 92%;"> <br><br>
                   
                   
        
                    <center><button type="submit">Update</button></center>
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