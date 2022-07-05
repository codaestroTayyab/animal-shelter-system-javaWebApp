<html>
<body>
<%
    session.invalidate();
%>
    <center>
    <p>You're Logged out now!</p>
    </center>
    <jsp:include page = "loginPage.html"/>

</body>
</html>
