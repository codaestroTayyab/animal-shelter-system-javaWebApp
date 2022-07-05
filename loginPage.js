function validate()
{
    var email = String();
    email = document.login.Email.value;
    if(email.indexOf('@') == -1 || email.indexOf('.') == -1)
    {
        alert("ERROR! Email format is not correct.");
        return;
    }

    else if(email.indexOf('@') < 1)
    {
        alert("ERROR! Email format is not correct.");
        return;
    }
    else if(email.indexOf('.') == email.indexOf('@') +1)
    {
        alert("ERROR! Email format is not correct.");
        return;
    }
    else if (email.indexOf('.') < email.indexOf('@'))
    {
        var halfEmail = Array();
        halfEmail = email.split('@');
        if(halfEmail[1].indexOf('.') < 1)
        {
            alert("ERROR! Email format is not correct.");
            return;
        }
    }
}