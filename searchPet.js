function validate()
{
    var flag = Boolean(false);

    if (document.getElementById("pName").value.length == 0 && document.getElementById("pid").value.length == 0
        && document.getElementById("ptype").value.length == 0 && document.getElementById("dos").value.length == 0
        && document.getElementById("age").value.length == 0)
    {   
        alert ("Fill atleast one input");
        return;
    }
    else
    {
        searchPet.submit();
    }
}