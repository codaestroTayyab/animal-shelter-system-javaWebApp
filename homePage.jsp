<html>
    <title>
        Animal Shelter System
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
               <center>Welcome user!</center>
            </h3>
            <div class="entries">
                <center>
                <button type="button" onclick= "document.location = 'admitPet.jsp'">Admit Pet</button>
                <br><br>
                <button type="button"  onclick="document.location = 'searchPet.jsp'">Search Pet</button>
                <br><br>
                <form action = "displayPet" method="post">
                    <button type="submit">Display All Pets</button>
                </form>
                
                <button type="button"  onclick="document.location = 'updatePet.jsp'">Update Pet Info</button>
                <br><br>
                <button type="button"  onclick="document.location = 'givePet.jsp'">Give Pet</button>
                <br><br>
                <br><br>
                <button type="button" name ="logout"  onclick="document.location = 'logout.jsp'">Logout</button>
                <br><br>
                </center>
                
            </div>   
        </div>
    <%
        }
    %>
    </body>
</html>