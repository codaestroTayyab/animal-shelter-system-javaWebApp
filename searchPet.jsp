<html>
    <title>
        Search Pet
    </title>
    <head>
        <link rel="stylesheet" href="loginPage.css">
        <script type="text/javascript" src="searchPet.js"></script>
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
               <center>Search Pet</center>
            </h3>
            <form name = "searchPet" action="searchPet" method="post" >
                <div class="entries">
                    <input type="text" name="petName" id ="pName" placeholder="Search by Name" style="width: 92%;" >
                    </p>
                    <input type="number" name="petID" id = "pid"placeholder="Search by ID" style="width: 92%;" ><br><br>
                    <input type="text" name="petType" id = "ptype"placeholder="Search by Pet Type" style="width: 92%;" ><br><br>
                    <input type="date" name="petDos" id = "dos"placeholder="Search by Date of Submission" style="width: 92%;" ><br><br>
                    <input type="number" name="petAge" id = "age"placeholder="Search by Age" style="width: 92%;" ><br><br>

                    <center><button type="button" onclick="validate()">Search</button></center>
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